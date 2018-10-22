package es.gate;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;

public class Fragment_Feed extends Fragment implements Runnable{

    private View feedView;
    private RecyclerView recyclerView;
    private Card_Feed_Adapter cardAdapter;
    private Twitter twitter;
    Handler cardAdapterHandler = new Handler() {
        @Override
        public void handleMessage(Message message) {

            cardAdapter.notifyDataSetChanged();
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.menu_feed, container, false);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("LkuYRcFUPw9s0EHpUXaz4rqeA")
                .setOAuthConsumerSecret("BcBfkOXcXvaDIkNPT8AgdNK67B9vByburY6l1RbOxQ0q4nw7Xp")
                .setOAuthAccessToken("2387971940-0d5HrsfGrWNF9BitQP7aiLU1HTb8wV7iitTKggB")
                .setOAuthAccessTokenSecret("csloQj77b0sjf8VNpLevHmV4hZfuzSFE5kp5AhS7cbXaH");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        recyclerView = view.findViewById(R.id.feedRecyclerView);
        recyclerView.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new Card_Feed_Adapter(Singleton_UserInformation.getInstance().getTweets(), getContext());
        recyclerView.setAdapter(cardAdapter);



        new Thread(this).start();

        feedView = view;
        return view;
    }

    public View getView(){
        return feedView;
    }

    @Override
    public void run() {
        Singleton_UserInformation userInfo;

        ArrayList<Card_Feed> tweets = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();




        tweets.clear();
        do{userInfo = Singleton_UserInformation.getInstance();}
        while(userInfo.getAccount() == null);

        for(Card_Interests cbm : userInfo.getAccount().getThemesInterest()){
            words.add(cbm.getInterest());
            words.addAll(cbm.getWords());
        }

        //todo get all words interests
        for(String word : words) {
            Query query = new Query(word + "-filter:RT");
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            for (Status status : result.getTweets()) {
                tweets.add(new Card_Feed(status.getText(), status.getUser(), status.getId(), status.getRetweetCount(), status.getFavoriteCount(), status.getCreatedAt()));
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        }

        System.out.println(tweets);
        userInfo.setTweets(tweets);
        System.out.println(userInfo.getTweets());
        System.out.println(Singleton_UserInformation.getInstance().getTweets() + "Y[E]");

        Message message = cardAdapterHandler.obtainMessage();
        message.setData(new Bundle());
        cardAdapterHandler.sendMessage(message);
    }

}

