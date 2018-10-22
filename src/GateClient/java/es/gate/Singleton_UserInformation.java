package es.gate;

import java.util.ArrayList;

public class Singleton_UserInformation {
    private static Singleton_UserInformation ourInstance;
    private ArrayList<String> userThemes;
    private ArrayList<Card_Feed> tweets = new ArrayList<>();
    private User_Account account;


    private Singleton_UserInformation() {
    }

    public static Singleton_UserInformation getInstance() {
        if(ourInstance == null){
            ourInstance = new Singleton_UserInformation();
        }
        return ourInstance;
    }

    public void setAccount(User_Account account) {
        this.account = account;
    }

    public User_Account getAccount() {
        return account;
    }

    public void setIdPass(String id, String pass){

        account.setUserID(id);
        account.setUserPass(pass);
    }

    public void setTweets(ArrayList<Card_Feed> tweets) {
        System.out.println(tweets);
        this.tweets.clear();
        this.tweets.addAll(tweets);
        System.out.println(this.tweets);
    }

    public ArrayList<Card_Feed> getTweets(){
        return tweets;
    }

}
