package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NTinfo {
    @SerializedName("INFO")
    @Expose
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
