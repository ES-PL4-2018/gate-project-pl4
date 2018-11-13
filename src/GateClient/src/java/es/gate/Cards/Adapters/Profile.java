package es.gate.Cards.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.ArrayList;
import java.util.Objects;

public class Profile extends RecyclerView.Adapter<Profile.CardViewHolder>{

    private RealmList<String> interests;
    private Realm realm;
    private Profile profileAdapter;
    private es.gate.Fragments.Profile parent;

    public Profile(es.gate.Fragments.Profile parent){

        realm = Realm.getDefaultInstance();

        interests = Objects.requireNonNull(realm.where(AccountInformation.class).findFirst()).getInterests();

        profileAdapter = this;
        this.parent = parent;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder profileCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                profileCardView.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v){
                        if(parent.isEditing()) {
                            realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            interests.remove(profileCardView.getAdapterPosition());
                            realm.commitTransaction();
                            realm.close();
                            profileAdapter.notifyItemRemoved(profileCardView.getAdapterPosition());
                        }
                        return true;
                    }
                });
            }
        },100);
        profileCardView.cardText.setText(interests.get(i));
        profileCardView.cardText.setBackgroundResource(R.color.transparent);
        profileCardView.cardText.setClickable(false);
    }

    @Override
    public int getItemCount() {
        return interests.size();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_profile, viewGroup, false);
        return new CardViewHolder(view);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView cardText;


        CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardProfile);
            cardText = itemView.findViewById(R.id.cardProfileView);
        }
    }

}
