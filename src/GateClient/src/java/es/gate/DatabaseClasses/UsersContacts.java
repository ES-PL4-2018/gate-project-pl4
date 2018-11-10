package es.gate.DatabaseClasses;

import es.gate.User_Account;
import io.realm.RealmObject;

public class UsersContacts extends RealmObject {

    private long userORCID;
    private long contactORCID;

    public UsersContacts(){}
    public UsersContacts(User_Account user, User_Account contact){
        this.userORCID = user.getUserORCID();
        this.contactORCID = contact.getUserORCID();
    }

    public long getContactORCID() {
        return contactORCID;
    }
}
