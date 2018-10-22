package es.gate;

import java.io.Serializable;
import java.util.ArrayList;

public class User_Account implements Serializable {

    private String userID;
    private String userPass;
    private String userEmail;
    private long userORCID;
    private String firstName;
    private String lastName;
    private String institution;
    private String investigation;
    private String researchUnits;
    private ArrayList<Card_Interests> themesInterest;
    private ArrayList<Card_Bookmark> userBookmark = new ArrayList<>();

    public String getUserID() {
        return userID;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public long getUserORCID() {
        return userORCID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInstitution() {
        return institution;
    }

    public String getInvestigation() {
        return investigation;
    }

    public String getResearchUnits() {
        return researchUnits;
    }

    public ArrayList<Card_Interests> getThemesInterest() {
        return themesInterest;
    }

    public ArrayList<Card_Bookmark> getUserBookmark() {
        return userBookmark;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserORCID(long userORCID) {
        this.userORCID = userORCID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    public void setResearchUnits(String researchUnits) {
        this.researchUnits = researchUnits;
    }

    public void setThemesInterest(ArrayList<Card_Interests> themesInterest) {
        this.themesInterest = themesInterest;
    }

    public void setUserBookmarks(ArrayList<Card_Bookmark> userBookmark) {
        this.userBookmark = userBookmark;
    }

    public void addUserBookmarks(Card_Bookmark userBookmark){
        this.userBookmark.add(userBookmark);
    }
}
