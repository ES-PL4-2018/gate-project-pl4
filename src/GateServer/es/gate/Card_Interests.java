package es.gate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Card_Interests implements Serializable {

    private ArrayList<String> relevantWords;
    private String interest;
    private boolean selected;


    public Card_Interests(String interest, String... words) {
        this.interest = interest;
        this.relevantWords = new ArrayList<>();
        /*for (String s : words) {
            relevantWords.add(s);
        }
        */
        relevantWords.addAll(Arrays.asList(words));

        selected = false;
    }

    public String getInterest(){
        return interest;
    }

    public ArrayList<String> getWords(){
        return relevantWords;
    }

    public void setSelected() {
        this.selected = !this.selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
}
