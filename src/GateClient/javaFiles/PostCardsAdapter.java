package es.gate;

import android.app.Activity;
import android.content.Context;
import android.support.transition.TransitionManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Joao Montenegro
 * 28/09/2018
 * Adaptador do RecyclerView, do tutorial android:
 * https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465
 */

public class PostCardsAdapter extends RecyclerView.Adapter<PostCardsAdapter.CardViewHolder> implements Serializable{

    private static final String TAG = "MyActivity";
    List<FeedPost> feedPosts;
    Feed mainActivity;
    private int mExpandedPosition = -1;

    PostCardsAdapter(List<FeedPost> feedPosts, Feed mainActivity){
        this.feedPosts = feedPosts;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder postsCardView, int i) {
        postsCardView.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onClick(view);
            }
        });
        postsCardView.username.setText(feedPosts.get(i).getUsername());
        postsCardView.category.setText(feedPosts.get(i).getCategory());
        postsCardView.contentFeed.setText(feedPosts.get(i).getContent());
        postsCardView.userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onClick(view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedPosts.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_feed, viewGroup, false);
        CardViewHolder pvh = new CardViewHolder(v);
        return pvh;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView username;
        TextView category;
        TextView contentFeed;
        ImageView userPhoto;


        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_post);
            username = itemView.findViewById(R.id.feed_post_card_username);
            category = itemView.findViewById(R.id.feed_post_card_category);
            contentFeed = itemView.findViewById(R.id.feed_post_card_content);
            userPhoto = itemView.findViewById(R.id.feed_post_card_userphoto);
        }
    }

}
