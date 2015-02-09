package com.siolabs.myapplication.model;

import android.os.Parcelable;

/**
 * Created by ashutoshsingh on 07-02-2015.
 */
public class CategoryItem  {

    public CategoryItem(String name, int numItems, int image, boolean isFinal, int parentId) {
        this.name = name;
        this.numItems = numItems;
        this.image = image;
        this.isFinal = isFinal;
        this.parentId = parentId;
    }

    public CategoryItem(String name, int numItems, int image) {
        this.name = name;
        this.numItems = numItems;
        this.image = image;
        this.parentId = 2403;
        this.isFinal = true;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int parentId;
    private String name;
    private int numItems;
    private int image;
    private boolean isFinal;
    //TODO Remove this to use with the database
    private String arrayName;


    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }
}
