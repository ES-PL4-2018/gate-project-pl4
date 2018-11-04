package es.gate.Cards.Adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import es.gate.R;
import es.gate.Singleton_ServerConnection;
import es.gate.Singleton_UserInformation;
import es.gate.Static_Functions;

import java.util.ArrayList;
import java.util.HashMap;

public class Bookmark extends RecyclerView.Adapter<Bookmark.CardViewHolder>{
    private static final String TAG = "MyActivity";
    ArrayList<es.gate.Cards.Bookmark> bookmarks;
    Context context;
    Bookmark parent;

    public Bookmark(ArrayList<es.gate.Cards.Bookmark> bookmarks, Context context){
        this.bookmarks = bookmarks;
        this.context = context;
        this.parent = this;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder bookmarkCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                bookmarkCardView.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = bookmarks.get(bookmarkCardView.getAdapterPosition()).getUrl();
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
                        bookmarks.remove(bookmarkCardView.getAdapterPosition());
                        parent.notifyDataSetChanged();
                        new Thread(new serverConnect()).start();
                        return true;
                    }
                });
            }
        },100);
        bookmarkCardView.tags.setText(bookmarks.get(i).getTags());
        bookmarkCardView.name.setText(bookmarks.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
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

    class serverConnect implements Runnable {

        private static final String TAG = "Menu_LoginThread";

        @Override
        public void run() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Singleton_UserInformation info = Singleton_UserInformation.getInstance();

            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileUserWrite(info.getAccount());

            communication = srv.sendMessage(communication);

            System.out.println(communication.get("writeResult"));
        }
    }
}
