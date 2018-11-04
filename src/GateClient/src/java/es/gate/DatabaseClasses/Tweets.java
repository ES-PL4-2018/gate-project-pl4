package es.gate.DatabaseClasses;

import io.realm.RealmObject;

public class Tweets extends RealmObject {

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
