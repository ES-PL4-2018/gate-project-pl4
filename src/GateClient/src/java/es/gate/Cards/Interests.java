package es.gate.Cards;

import java.io.Serializable;

public class Interests implements Serializable {

    private String interest;
    private boolean selected;


    public Interests(String interest) {
        this.interest = interest;
        selected = false;
    }

    public String getInterest() {
        return interest;
    }

    public void setSelected() {
        this.selected = !this.selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
