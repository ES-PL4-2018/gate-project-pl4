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
import es.gate.DatabaseClasses.UsersDiscovered;
import es.gate.Discover.ContactProfile;
import es.gate.Fragments.Discovery;
import es.gate.R;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.Objects;

public class Discovery_Add extends RecyclerView.Adapter<Discovery_Add.CardViewHolder> {

    public RealmList<UsersDiscovered> usersDiscovered;
    private String curAccount;
    private Discovery parent;

    public Discovery_Add(String curAccount, Discovery parent) {
        this.curAccount = curAccount;
        this.parent = parent;
        Realm realm = Realm.getDefaultInstance();
        this.usersDiscovered = new RealmList<>();
        this.usersDiscovered.addAll(Objects.requireNonNull(realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst()).getUsersDiscovered());
        realm.close();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Discovery_Add.CardViewHolder contactCardView, int i) {

        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                contactCardView.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new ContactProfile(curAccount, String.valueOf(Objects.requireNonNull(usersDiscovered.get(contactCardView.getAdapterPosition())).getUserORCID()), parent, parent.getContext());
                    }
                });
            }
        }, 100);
        contactCardView.name.setText(Objects.requireNonNull(usersDiscovered.get(i)).getUserName());
        // TODO image set
    }

    @Override
    public int getItemCount() {
        return usersDiscovered.size();
    }

    @NonNull
    @Override
    public Discovery_Add.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_discovery_add, viewGroup, false);
        return new Discovery_Add.CardViewHolder(v);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        ImageView image;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_discovery_add);
            name = itemView.findViewById(R.id.cardDiscoveryAddText);
            image = itemView.findViewById(R.id.cardDiscoveryAddImage);
            // TODO image
        }
    }
}
