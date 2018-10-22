package es.gate;

import java.io.Serializable;

public class Card_Bookmark implements Serializable {

    private String name;
    private String tags;
    private String url;

    public Card_Bookmark(String tags, String name, String url) {
        this.tags = tags;
        this.name = name;
        this.url = url;
    }

    /*----Getters and setters-------*/


    public String getName() {
        return name;
    }

    public String getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
