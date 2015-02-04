package com.siolabs.myapplication.model;


import java.util.ArrayList;
/**
 * Created by ashutoshsingh on 04-02-2015.
 */
public class AdItem {

    private String title, thumbnailUrl;
    private int price;
    private boolean isNegotiable;
    private String postTime;
    private String city;


    public AdItem(){    }
    public AdItem(String title, String thumbnailUrl, int price, boolean isNegotiable, String time, String city ){
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.isNegotiable = isNegotiable;
        this.postTime  = time;
        this.city = city;

    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isNegotiable() {
        return isNegotiable;
    }

    public void setNegotiable(boolean isNegotiable) {
        this.isNegotiable = isNegotiable;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    
}
