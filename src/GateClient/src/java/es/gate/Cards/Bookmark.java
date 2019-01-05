package es.gate.Cards;

import java.io.Serializable;

public class Bookmark implements Serializable {

    private String name;
    private String tags;
    private String url;

    public Bookmark(String tags, String name, String url) {
        this.tags = tags;
        this.name = name;
        this.url = url;
    }

    /*----Getters and setters-------*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
