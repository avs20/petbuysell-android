package com.siolabs.myapplication.model;

/**
 * Created by ashutoshsingh on 07-02-2015.
 */
public class CategoryItem {

    public CategoryItem(String name, int numItems, int image) {
        this.name = name;
        this.numItems = numItems;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String name;
    private int numItems;
    private int image;
    
    
    
    
}
