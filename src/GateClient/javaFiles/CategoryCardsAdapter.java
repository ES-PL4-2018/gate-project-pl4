package es.gate;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Joao Montenegro
 * Adaptador do RecyclerView, como o PostCardsAdapter, mas para a lista de categorias
 */

public class CategoryCardsAdapter extends RecyclerView.Adapter<CategoryCardsAdapter.CardViewHolder> {

    List<FeedCategory> feedCategories;

    CategoryCardsAdapter(List<FeedCategory> feedCategories){
        this.feedCategories = feedCategories;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder categoryViewHolder, int i) {
        categoryViewHolder.category.setText(feedCategories.get(i).getCategory());
    }

    @Override
    public int getItemCount() {
        return feedCategories.size();
    }

    @Override
    public CategoryCardsAdapter.CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_category, viewGroup, false);
        CardViewHolder pvh = new CardViewHolder(v);
        return pvh;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView category;


        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_category);
            category = itemView.findViewById(R.id.feed_category_name);
        }
    }

}
