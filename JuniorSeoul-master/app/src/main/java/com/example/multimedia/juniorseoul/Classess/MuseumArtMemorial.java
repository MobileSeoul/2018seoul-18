package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MuseumArtMemorial {
    @SerializedName("list")
    @Expose
    private ArrayList<MuseumArtMemorialList> museumArtMemorialList = null;

    public ArrayList<MuseumArtMemorialList> getMuseumArtMemorialList() {
        return museumArtMemorialList;
    }

    public void setMuseumArtMemorialList(ArrayList<MuseumArtMemorialList> museumArtMemorialList){
        this.museumArtMemorialList = museumArtMemorialList;
    }
}
