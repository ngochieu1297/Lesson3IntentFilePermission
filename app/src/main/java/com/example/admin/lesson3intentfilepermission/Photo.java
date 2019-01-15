package com.example.admin.lesson3intentfilepermission;

public class Photo {
    private String mUrl;
    private String mTitle;

    public Photo(String title, String url) {
        mUrl = url;
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
