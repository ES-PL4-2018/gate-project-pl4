package es.gate.DatabaseClasses;

import io.realm.RealmObject;

import java.util.Date;

public class UsersConnected extends RealmObject {

    private long userORCID;
    private String userEmail;
    private String userName;
    private String institution;
    private String researchUnits;
    private Date lastSeen;

    public long getUserORCID() {
        return userORCID;
    }

    public void setUserORCID(long userORCID) {
        this.userORCID = userORCID;
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

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }
}
