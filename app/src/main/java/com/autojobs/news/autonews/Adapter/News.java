package com.autojobs.news.autonews.Adapter;

/**
 * Created by Ayothi selvam on 11-11-2017.
 */

public class News {

    String title,description,date,image;

    public News(String title, String description, String date, String image) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }
}
