package es.gate;

import java.io.Serializable;

/**
 * Joao Montenegro
 * 28/09/18
 * Classe dos dados de um post no feed, cada CardView tem um feedPost
 */

public class FeedPost implements Serializable{
    private String username;
    private int timeposted = 0;
    private String userphoto_id = "R.id.mipmap.comment_icon_small";
    private String category;
    private String content;
    private String contentphoto_id = "R.id.mipmap.comment_icon_small";

    public FeedPost(String username, String category, String content) {
        this.username = username;
        this.category = category;
        this.content = content;
    }

    /*-----Getters/Setters------*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTimeposted() {
        return timeposted;
    }

    public void setTimeposted(int timeposted) {
        this.timeposted = timeposted;
    }

    public String getUserphoto_id() {
        return userphoto_id;
    }

    public void setUserphoto_id(String userphoto_id) {
        this.userphoto_id = userphoto_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentphoto_id() {
        return contentphoto_id;
    }

    public void setContentphoto_id(String contentphoto_id) {
        this.contentphoto_id = contentphoto_id;
    }
}
