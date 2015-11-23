package com.beginner.ebolapp;

/**
 * Created by vijay singh on 21-11-2015.
 */
public class Concert {
    private  String title;
    private String link;
    private String imageLink;

    public Concert(String title,String link,String imageLink){
        this.title = title;
        this.link = link;
        this.imageLink = imageLink;
    }

    public String getLink() {
        return link;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getTitle() {
        return title;
    }
}


