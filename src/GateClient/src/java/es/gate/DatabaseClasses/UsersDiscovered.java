package es.gate.DatabaseClasses;

import io.realm.RealmObject;
import java.util.Date;

public class UsersDiscovered extends RealmObject {

    private long userORCID;
    private String userName;
    private Date lastSeen;
    private String lastKnownIP;


    public long getUserORCID() {
        return userORCID;
    }

    public void setUserORCID(long userORCID) {
        this.userORCID = userORCID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastKnownIP() {
        return lastKnownIP;
    }

    public void setLastKnownIP(String lastKnownIP) {
        this.lastKnownIP = lastKnownIP;
    }
}
