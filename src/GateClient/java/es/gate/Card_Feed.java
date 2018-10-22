package es.gate;

import twitter4j.User;

import java.util.Date;

public class Card_Feed {

    private User userInfo;
    private String text;
    private long url;
    private int retweets;
    private int favorites;
    private Date dateCreated;

    public Card_Feed(String text, User userInfo, long url, int retweets, int favorites, Date dateCreated) {
        this.userInfo = userInfo;
        this.text = text;
        this.url = url;
        this.retweets = retweets;
        this.favorites = favorites;
        this.dateCreated = dateCreated;
    }

    /*----Getters and setters-------*/


    public User getUserInfo() {
        return userInfo;
    }

    public String getText() {
        return text;
    }

    public long getUrl() {
        return url;
    }

    public int getRetweets() {
        return retweets;
    }

    public int getFavorites() {
        return favorites;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}

