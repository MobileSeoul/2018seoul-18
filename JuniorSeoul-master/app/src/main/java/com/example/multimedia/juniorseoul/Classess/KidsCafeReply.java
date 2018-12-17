package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KidsCafeReply {
    @SerializedName("list")
    @Expose
    private ArrayList<ReplyList> replyList = null;

    @SerializedName("FLAG")
    @Expose
    private boolean flag;

    @SerializedName("RATING")
    @Expose
    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ArrayList<ReplyList> getReplyList() {
        return replyList;
    }

    public void setReplyList(ArrayList<ReplyList> replyList){
        this.replyList = replyList;
    }
}
