package es.gate.DatabaseClasses;

import io.realm.RealmObject;

public class Bookmarks extends RealmObject {

    private String bmName;
    private String bmUrl;
    private String bmTags;

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getBmUrl() {
        return bmUrl;
    }

    public void setBmUrl(String bmUrl) {
        this.bmUrl = bmUrl;
    }

    public String getBmTags() {
        return bmTags;
    }

    public void setBmTags(String bmTags) {
        this.bmTags = bmTags;
    }
}
