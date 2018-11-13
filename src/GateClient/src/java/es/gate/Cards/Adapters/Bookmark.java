package es.gate.Cards.Adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.Bookmarks;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.Objects;

public class Bookmark extends RecyclerView.Adapter<Bookmark.CardViewHolder>{
    private RealmList<Bookmarks> bookmarks;
    private Context context;
    private Bookmark bookmarkAdapter;
    private Realm realm;

    public Bookmark(Context context){
        realm = Realm.getDefaultInstance();
        this.bookmarks = Objects.requireNonNull(realm.where(AccountInformation.class).findFirst()).getUserBookmark();
        this.context = context;
        this.bookmarkAdapter = this;
        realm.close();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder bookmarkCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                bookmarkCardView.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = Objects.requireNonNull(bookmarks.get(bookmarkCardView.getAdapterPosition())).getBmUrl();
                        if (!url.startsWith("http://") && !url.startsWith("https://"))
                            url = "http://" + url;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        try{
                            context.startActivity(intent);
                        }catch (ActivityNotFoundException e){
                            Toast.makeText(context, "Invalid link", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                bookmarkCardView.cv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        bookmarks.remove(bookmarkCardView.getAdapterPosition());
                        realm.isEmpty();
                        realm.commitTransaction();
                        realm.close();
                        bookmarkAdapter.notifyItemRemoved(bookmarkCardView.getAdapterPosition());
                        return true;
                    }
                });
            }
        },100);
        bookmarkCardView.tags.setText(Objects.requireNonNull(bookmarks.get(i)).getBmTags());
        bookmarkCardView.name.setText(Objects.requireNonNull(bookmarks.get(i)).getBmName());
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_bookmark, viewGroup, false);
        return new CardViewHolder(v);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView tags;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardBookmark);
            name = itemView.findViewById(R.id.bookmarkTitle);
            tags = itemView.findViewById(R.id.bookmarkTag);
        }
    }
}
