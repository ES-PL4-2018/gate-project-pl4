package es.gate.DatabaseClasses;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Tweets extends RealmObject {

    @PrimaryKey
    private long tweetID;
    private String interest;


    public long getTweetID() {
        return tweetID;
    }

    public void setTweetID(long tweetID) {
        this.tweetID = tweetID;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
