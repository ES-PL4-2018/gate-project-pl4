package es.gate.DatabaseClasses;

import io.realm.RealmList;
import io.realm.RealmObject;

public class AccountInformation extends RealmObject {

    private long userORCID;
    private String userPass;
    private byte[] image; //TODO think about how to handle images
    private String userEmail;
    private String userName;
    private String institution;
    private String researchUnits;
    private RealmList<String> interests;
    private RealmList<Bookmarks> userBookmark = new RealmList<>();


    public long getUserORCID() {
        return userORCID;
    }

    public void setUserORCID(long userORCID) {
        this.userORCID = userORCID;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getResearchUnits() {
        return researchUnits;
    }

    public void setResearchUnits(String researchUnits) {
        this.researchUnits = researchUnits;
    }

    public RealmList<String> getInterests() {
        return interests;
    }

    public void setInterests(RealmList<String> interests) {
        this.interests = interests;
    }

    public RealmList<Bookmarks> getUserBookmark() {
        return userBookmark;
    }

    public void setUserBookmark(RealmList<Bookmarks> userBookmark) {
        this.userBookmark = userBookmark;
    }
}
