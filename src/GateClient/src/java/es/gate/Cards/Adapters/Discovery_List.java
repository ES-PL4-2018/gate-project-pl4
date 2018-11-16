package es.gate.Cards.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.UsersConnected;
import es.gate.Fragments.Discovery;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.Objects;

public class Discovery_List extends RecyclerView.Adapter<Discovery_List.CardViewHolder> {

    private RealmList<UsersConnected> usersConnected;
    private Discovery discoveryInstance;
    private Realm realm;
    private Discovery_List discoveryAdapter;
    private String curAccount;

    public Discovery_List(String curAccount, Discovery discoveryInstance) {
        this.curAccount = curAccount;
        this.discoveryInstance = discoveryInstance;
        this.discoveryAdapter = this;
        realm = Realm.getDefaultInstance();
        this.usersConnected = new RealmList<>();
        this.usersConnected.addAll(Objects.requireNonNull(realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst()).getUsersConnected());
        realm.close();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Discovery_List.CardViewHolder contactCardView, int i) {

        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                contactCardView.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        discoveryInstance.viewUserProfile(String.valueOf(Objects.requireNonNull(usersConnected.get(contactCardView.getAdapterPosition())).getUserORCID()));
                    }
                });

                contactCardView.cv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        realm.where(AccountInformation.class)
                                .equalTo("orcid", curAccount)
                                .findFirst()
                                .getUsersConnected()
                                .remove(contactCardView.getAdapterPosition());
                        realm.commitTransaction();
                        usersConnected.remove(contactCardView.getAdapterPosition());
                        realm.close();
                        discoveryAdapter.notifyItemRemoved(contactCardView.getAdapterPosition());
                        return true;
                    }
                });
            }
        }, 100);


        contactCardView.name.setText(Objects.requireNonNull(usersConnected.get(i)).getUserName());
        contactCardView.lastSeen.setText(Objects.requireNonNull(String.valueOf(Objects.requireNonNull(usersConnected.get(i)).getLastSeen().getTime()))); //TODO set time function to diplay last time seen
        // TODO image set
    }

    @Override
    public int getItemCount() {
        return usersConnected.size();
    }

    @NonNull
    @Override
    public Discovery_List.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_discovery_contact, viewGroup, false);
        return new Discovery_List.CardViewHolder(v);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView lastSeen;
        ImageView image;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_discovery_contact);
            name = itemView.findViewById(R.id.cardDiscoveryContactText);
            lastSeen = itemView.findViewById(R.id.cardDiscoveryContactLastSeen);
            image = itemView.findViewById(R.id.cardDiscoveryContactImage);
            // TODO image
        }
    }
}
