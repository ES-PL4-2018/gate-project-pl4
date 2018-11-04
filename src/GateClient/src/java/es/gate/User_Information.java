package es.gate;

import es.gate.Cards.Feed;

import java.util.ArrayList;

public class User_Information {

    private User_Account account;
    private ArrayList<String> userInterests;
    private ArrayList<Feed> tweets = new ArrayList<>();

    public void setIdPass(String id, String pass){

        account.setUserID(id);
        account.setUserPass(pass);
    }

    public void setAccount(User_Account account) {
        this.account = account;
    }

    public User_Account getAccount() {
        return account;
    }

    public void setTweets(ArrayList<Feed> tweets) {
        System.out.println(tweets);
        this.tweets.clear();
        this.tweets.addAll(tweets);
        System.out.println(this.tweets);
    }

    public ArrayList<Feed> getTweets(){
        return tweets;
    }


}
