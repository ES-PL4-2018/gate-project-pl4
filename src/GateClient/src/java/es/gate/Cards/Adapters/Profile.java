package es.gate.Cards.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import es.gate.Cards.Interests;
import es.gate.R;

import java.util.ArrayList;
import java.util.List;

public class Profile extends RecyclerView.Adapter<Profile.CardViewHolder>{

    private static final String TAG = "MyActivity";
    private View view;
    private List<Interests> interests;
    private ArrayList<Button> buttons = new ArrayList<>();

    public Profile(List<Interests> interests){
        this.interests = interests;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder profileCardView, int i) {
        android.os.Handler h = new android.os.Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                profileCardView.cardButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //registerActivity.registerInterestsOnClick(view);
                        interests.get(profileCardView.getAdapterPosition()).setSelected();

                        if(interests.get(profileCardView.getAdapterPosition()).isSelected()){
                            profileCardView.cardButton.setBackgroundResource(R.drawable.button_white_center);
                            profileCardView.cardButton.setTextColor(view.getResources().getColor(R.color.black, null));
                        }else {
                            profileCardView.cardButton.setBackgroundResource(R.drawable.button_white_outline);
                            profileCardView.cardButton.setTextColor(view.getResources().getColor(R.color.white, null));
                        }

                    }
                });
            }
        },100);
        profileCardView.cardButton.setText(interests.get(i).getInterest());
        profileCardView.cardButton.setBackgroundResource(R.color.transparent);
        profileCardView.cardButton.setClickable(false);
        buttons.add(profileCardView.cardButton);
    }

    @Override
    public int getItemCount() {
        return interests.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_profile, viewGroup, false);
        this.view = view;
        return new CardViewHolder(view);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        Button cardButton;


        CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardProfile);
            cardButton = itemView.findViewById(R.id.cardProfileButton);
        }
    }

    public void setButtonsInvisible(){

        for(Button b : buttons){
            b.setBackgroundResource(R.color.transparent);
            b.setTextColor(view.getResources().getColor(R.color.white, null));
            b.setClickable(false);
            b.setFocusable(false);
        }
    }

    public void setButtonsVisible(){

        try {
            for (Button b : buttons) {
                if (interests.get(buttons.indexOf(b)).isSelected()) {
                    b.setBackgroundResource(R.drawable.button_white_center);
                    b.setTextColor(view.getResources().getColor(R.color.black, null));
                } else {
                    b.setBackgroundResource(R.drawable.button_white_outline);
                    b.setTextColor(view.getResources().getColor(R.color.white, null));
                }
                b.setClickable(true);
                b.setFocusableInTouchMode(true);
            }
        }catch (IndexOutOfBoundsException e){
            //rip
        }
    }

}
