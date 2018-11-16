package es.gate.Cards.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import es.gate.Cards.Interests;
import es.gate.R;

import java.util.List;

public class Register extends RecyclerView.Adapter<Register.CardViewHolder> {

    private static final String TAG = "MyActivity";
    private List<Interests> interests;

    public Register(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder registerCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                registerCardView.cardButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //registerActivity.registerInterestsOnClick(view);
                        interests.get(registerCardView.getAdapterPosition()).setSelected();

                        if (interests.get(registerCardView.getAdapterPosition()).isSelected()) {
                            registerCardView.cardButton.setBackgroundResource(R.drawable.button_white_center);
                        } else {
                            registerCardView.cardButton.setBackgroundResource(R.drawable.button_white_outline);
                        }
                    }
                });
            }
        }, 100);
        registerCardView.cardButton.setText(interests.get(i).getInterest());
    }

    @Override
    public int getItemCount() {
        return interests.size();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_register, viewGroup, false);
        return new CardViewHolder(view);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        Button cardButton;


        CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardRegister);
            cardButton = itemView.findViewById(R.id.cardRegisterButton);
        }
    }

}
