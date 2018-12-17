package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KidsCafe {
    @SerializedName("list")
    @Expose
    private ArrayList<CafeList> cafeList = null;

    public ArrayList<CafeList> getCafeList() {
        return cafeList;
    }

    public void setCafeList(ArrayList<CafeList> cafeList){
        this.cafeList = cafeList;
    }
}
