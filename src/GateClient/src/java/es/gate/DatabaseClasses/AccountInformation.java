package es.gate.DatabaseClasses;

import es.gate.Fragments.Bookmark;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import java.io.Serializable;

public class AccountInformation extends RealmObject implements Serializable {

    @PrimaryKey
    private String orcid;
    private String password;
    private byte[] image; //TODO think about how to handle images
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String institution;
    private String investigationUnits;
    private RealmList<String> interests;
    private RealmList<Bookmarks> userBookmark;
    private RealmList<Tweets> sessionTweets;
    private RealmList<UsersDiscovered> usersDiscovered;
    private RealmList<UsersConnected> usersConnected;

    public AccountInformation() {
        userBookmark = new RealmList<>();
        sessionTweets = new RealmList<>();
        usersDiscovered = new RealmList<>();
        usersConnected = new RealmList<>();
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInvestigationUnits() {
        return investigationUnits;
    }

    public void setInvestigationUnits(String investigationUnits) {
        this.investigationUnits = investigationUnits;
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

    public RealmList<Tweets> getSessionTweets() {
        return sessionTweets;
    }

    public void setSessionTweets(RealmList<Tweets> sessionTweets) {
        this.sessionTweets = sessionTweets;
    }

    public RealmList<UsersDiscovered> getUsersDiscovered() {
        return usersDiscovered;
    }

    public void setUsersDiscovered(RealmList<UsersDiscovered> usersDiscovered) {
        this.usersDiscovered = usersDiscovered;
    }

    public RealmList<UsersConnected> getUsersConnected() {
        return usersConnected;
    }

    public void setUsersConnected(RealmList<UsersConnected> usersConnected) {
        this.usersConnected = usersConnected;
    }
}
