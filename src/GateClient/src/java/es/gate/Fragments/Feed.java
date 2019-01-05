package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Main;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;

public class Feed extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private View feedView;
    private SwipeRefreshLayout swipeLayoutView;
    private RecyclerView recyclerView;
    private String query;
    private String curAccount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        curAccount = ((Main) Objects.requireNonNull(getActivity())).getCurAccount();

        View view = inflater.inflate(R.layout.menu_feed, container, false);
        Properties props = new Properties();
        try {
            props.load(Objects.requireNonNull(getActivity()).getBaseContext().getAssets().open("twitter.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String twitterInfo[] = new String[4];
        for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements(); ) {
            String name = (String) e.nextElement();
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

        TwitterConfig config = new TwitterConfig.Builder(Objects.requireNonNull(getContext()))
                .twitterAuthConfig(new TwitterAuthConfig(twitterInfo[0], twitterInfo[1]))
                .debug(true)
                .build();
        com.twitter.sdk.android.core.Twitter.initialize(config);

        FloatingActionButton postTwitter = view.findViewById(R.id.postTwitter);

        postTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                        .getActiveSession();
                if (session == null) {
                    Toast.makeText(getContext(), "Please login to post", Toast.LENGTH_LONG).show();
                    return;
                }
                TweetComposer.Builder builder = new TweetComposer.Builder(Objects.requireNonNull(getContext()));
                builder.show();
            }

        });

        swipeLayoutView = view.findViewById(R.id.feedSwipeRefresh);
        swipeLayoutView.setOnRefreshListener(this);

        recyclerView = view.findViewById(R.id.feedRecyclerView);
        recyclerView.setHasFixedSize(true);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);

        updateQuery();

        final SearchTimeline timeline = new SearchTimeline.Builder()
                .query(query)
                //.resultType(SearchTimeline.ResultType.POPULAR)
                .build();
        final TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(getContext())
                .setTimeline(timeline)
                .setViewStyle(R.style.tw__TweetDarkWithActionsStyle)
                .build();

        recyclerView.setAdapter(adapter);

        swipeLayoutView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayoutView.setRefreshing(true);
                if (updateQuery()) {
                    final SearchTimeline timeline = new SearchTimeline.Builder()
                            .query(query)
                            //.resultType(SearchTimeline.ResultType.POPULAR)
                            .build();
                    final TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(getContext())
                            .setTimeline(timeline)
                            .setViewStyle(R.style.tw__TweetDarkWithActionsStyle)
                            .build();

                    recyclerView.setAdapter(adapter);
                    swipeLayoutView.setRefreshing(false);
                } else {
                    adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                        @Override
                        public void success(Result<TimelineResult<Tweet>> result) {
                            swipeLayoutView.setRefreshing(false);
                        }

                        @Override
                        public void failure(com.twitter.sdk.android.core.TwitterException exception) {
                            Toast.makeText(getContext(), "There was a problem fetching tweets", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
        feedView = view;
        return view;


    }

    public View getView() {
        return feedView;
    }

    @Override
    public void onRefresh() {

        swipeLayoutView.setRefreshing(true);
    }

    private boolean updateQuery() {

        Realm realm = Realm.getDefaultInstance();
        AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();

        assert accInfo != null;
        RealmList<String> interests = accInfo.getInterests();

        String newQuery = "";

        for (String s : interests) {
            newQuery = newQuery.concat("#" + s);
            if (!Objects.equals(interests.last(), s)) {
                newQuery = newQuery.concat(" OR ");
            }
        }

        System.out.println(query);
        System.out.println(newQuery);
        if (!newQuery.equals(query)) {
            query = newQuery;
            return true;
        }
        return false;
    }

}

