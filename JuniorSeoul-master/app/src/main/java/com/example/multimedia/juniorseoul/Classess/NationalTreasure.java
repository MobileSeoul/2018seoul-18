package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NationalTreasure {
    @SerializedName("list")
    @Expose
    private ArrayList<NationalTreasureList> nationalTreasureList = null;

    public ArrayList<NationalTreasureList> getNationalTreasureList() {
        return nationalTreasureList;
    }

    public void setNationalTreasureList(ArrayList<NationalTreasureList> nationalTreasureList){
        this.nationalTreasureList = nationalTreasureList;
    }
}
