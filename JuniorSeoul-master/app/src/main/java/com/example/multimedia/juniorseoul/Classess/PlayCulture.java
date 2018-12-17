package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlayCulture {
    @SerializedName("list")
    @Expose
    private ArrayList<PlayCultureList> playCultureList = null;

    public ArrayList<PlayCultureList> getPlayCultureList() {
        return playCultureList;
    }

    public void setPlayCultureList(ArrayList<PlayCultureList> playCultureList){
        this.playCultureList = playCultureList;
    }
}
