package es.gate.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.Tweets;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;

public class Feed extends Fragment implements Runnable, SwipeRefreshLayout.OnRefreshListener{

    private View feedView;
    private SwipeRefreshLayout swipeLayoutView;
    private RecyclerView recyclerView;
    private Twitter twitter;

    @SuppressLint("HandlerLeak")
    private Handler cardAdapterHandler = new Handler() {
        @Override
        public void handleMessage(Message message) {

            es.gate.Cards.Adapters.Feed cardAdapter = new es.gate.Cards.Adapters.Feed(getContext());
            recyclerView.setAdapter(cardAdapter);
            cardAdapter.notifyDataSetChanged();
            swipeLayoutView.setRefreshing(false);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.menu_feed, container, false);


        Properties props = new Properties();
        try {
            props.load(Objects.requireNonNull(getActivity()).getBaseContext().getAssets().open("twitter.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String twitterInfo[] = new String[4];
        for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements(); ) {
            String name = (String)e.nextElement();
            String value = props.getProperty(name);
            // now you have name and value
            if (name.startsWith("ConsumerKey")) {
                twitterInfo[0] = value;
            }
            if (name.startsWith("ConsumerSecret")) {
                twitterInfo[1] = value;
            }
            if (name.startsWith("AccessToken")) {
                twitterInfo[2] = value;
            }
            if (name.startsWith("TokenSecret")) {
                twitterInfo[3] = value;
            }
        }

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterInfo[0])
                .setOAuthConsumerSecret(twitterInfo[1])
                .setOAuthAccessToken(twitterInfo[2])
                .setOAuthAccessTokenSecret(twitterInfo[3]);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        TwitterConfig config = new TwitterConfig.Builder(Objects.requireNonNull(getContext()))
                .twitterAuthConfig(new TwitterAuthConfig(twitterInfo[0], twitterInfo[1]))
                .debug(true)
                .build();
        com.twitter.sdk.android.core.Twitter.initialize(config);


        swipeLayoutView = view.findViewById(R.id.feedSwipeRefresh);
        swipeLayoutView.setOnRefreshListener(this);

        recyclerView = view.findViewById(R.id.feedRecyclerView);
        recyclerView.setHasFixedSize(true);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);

        swipeLayoutView.setRefreshing(true);

        new Thread(this).start();

        feedView = view;
        return view;
    }

    public View getView(){
        return feedView;
    }

    @Override
    public void onRefresh() {

        swipeLayoutView.setRefreshing(true);

        new Thread(this).start();
    }

    @Override
    public void run() {

        Realm realm = Realm.getDefaultInstance();
        AccountInformation accInfo = realm.where(AccountInformation.class).findFirst();

        realm.beginTransaction();
        realm.where(Tweets.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();

        assert accInfo != null;
        RealmList<String> interests = accInfo.getInterests();
        RealmList<Tweets> sessionTweets = new RealmList<>();

        for(String interest : interests) {
            Query query = new Query("#" + interest + " -filter:retweets");
            query.count(5);
            query.setResultType(Query.POPULAR);
            query.lang("en");
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }try {
                assert result != null;
                for (Status status : result.getTweets()) {
                    realm.beginTransaction();
                    Tweets tweet;
                    try {
                        tweet = realm.createObject(Tweets.class, status.getId());
                        sessionTweets.add(tweet);
                    }catch(RealmPrimaryKeyConstraintException e){
                        Log.d("Feed", "Tweet already in list");
                    }
                    realm.commitTransaction();

                }
            }catch(NullPointerException e){
                Toast.makeText(getContext(), "There was an error fetching tweets", Toast.LENGTH_LONG).show();
                return;
            }
        }
        realm.beginTransaction();
        accInfo.setSessionTweets(sessionTweets);
        realm.commitTransaction();
        realm.close();

        Message message = cardAdapterHandler.obtainMessage();
        message.setData(new Bundle());
        cardAdapterHandler.sendMessage(message);
    }

}

