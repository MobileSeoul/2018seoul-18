package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Treasure {
    @SerializedName("list")
    @Expose
    private ArrayList<TreasureList> treasureList = null;

    public ArrayList<TreasureList> getTreasureList() {
        return treasureList;
    }

    public void setTreasureList(ArrayList<TreasureList> treasureList){
        this.treasureList = treasureList;
    }
}
