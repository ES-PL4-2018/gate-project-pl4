package es.gate.Cards.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.Tweets;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.ArrayList;
import java.util.Objects;

public class Feed extends RecyclerView.Adapter<Feed.CardViewHolder>{

    private RealmList<Tweets> tweets;
    private Context context;

    public Feed(Context context){

        Realm realm = Realm.getDefaultInstance();

        this.tweets = Objects.requireNonNull(realm.where(AccountInformation.class).findFirst()).getSessionTweets();
        System.out.println(this.tweets);
        this.context = context;
        realm.close();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Feed.CardViewHolder feedCardView, int i) {

        TweetUtils.loadTweet(Objects.requireNonNull(tweets.get(feedCardView.getAdapterPosition())).getTweetID(), new com.twitter.sdk.android.core.Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                System.out.println(result.data);
                feedCardView.cv.addView(new TweetView(context, result.data, R.style.tw__TweetDarkWithActionsStyle));
            }       //TODO fix overlapping tweets

            @Override
            public void failure(com.twitter.sdk.android.core.TwitterException exception) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    @NonNull
    @Override
    public Feed.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_tweet, viewGroup, false);
        return new Feed.CardViewHolder(v);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.tweetView);
        }
    }
}
