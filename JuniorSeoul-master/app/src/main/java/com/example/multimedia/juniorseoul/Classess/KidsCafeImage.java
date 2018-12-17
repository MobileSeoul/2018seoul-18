package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KidsCafeImage {
    @SerializedName("list")
    @Expose
    private ArrayList<ImageList> imageList = null;

    public ArrayList<ImageList> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<ImageList> imageList){
        this.imageList = imageList;
    }
}
