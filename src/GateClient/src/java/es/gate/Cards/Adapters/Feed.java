package es.gate.Cards.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import es.gate.R;

import java.util.ArrayList;

public class Feed extends RecyclerView.Adapter<Feed.CardViewHolder>{
    private static final String TAG = "MyActivity";
    ArrayList<es.gate.Cards.Feed> tweets;
    Context context;

    public Feed(ArrayList<es.gate.Cards.Feed> tweets, Context context){
        this.tweets = tweets;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final Feed.CardViewHolder feedCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                feedCardView.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent openTwitter = null;

                            openTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/user/status/" + tweets.get(feedCardView.getAdapterPosition()).getUrl()));

                        context.startActivity(openTwitter);
                    }
                });
            }
        },100);
        feedCardView.userName.setText(tweets.get(i).getUserInfo().getName());
        feedCardView.text.setText(tweets.get(i).getText());
        feedCardView.favorites.setText("Likes\n" + tweets.get(i).getFavorites());
        feedCardView.retweets.setText("Retweets\n" + tweets.get(i).getRetweets());
        feedCardView.date.setText(tweets.get(i).getDateCreated().toString());
        Glide.with(this.context).load(tweets.get(i).getUserInfo().get400x400ProfileImageURL()).into(feedCardView.userPicture);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    @Override
    public Feed.CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_tweet, viewGroup, false);
        return new Feed.CardViewHolder(v);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView userName;
        TextView text;
        TextView favorites;
        TextView retweets;
        TextView date;
        ImageView userPicture;


        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardFeed);
            userName = itemView.findViewById(R.id.feedUserName);
            text = itemView.findViewById(R.id.feedText);
            favorites = itemView.findViewById(R.id.feedFavorites);
            retweets = itemView.findViewById(R.id.feedRetweets);
            date = itemView.findViewById(R.id.feedDate);
            userPicture = itemView.findViewById(R.id.feedProfilePicture);
        }
    }
}
