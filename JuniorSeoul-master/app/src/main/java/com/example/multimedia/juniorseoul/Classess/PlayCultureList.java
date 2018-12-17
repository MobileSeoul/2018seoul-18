package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayCultureList {
    @SerializedName("CULTURE_ID")
    @Expose
    private int id;

    @SerializedName("TITLE")
    @Expose
    private String title;

    @SerializedName("END_DAY")
    @Expose
    private String end_day;

    @SerializedName("OPEN_TIME")
    @Expose
    private String open_time;

    @SerializedName("PLACE")
    @Expose
    private String place;

    @SerializedName("LINK")
    @Expose
    private String link;

    @SerializedName("IMAGE_URL")
    @Expose
    private String image_url;

    @SerializedName("TEL_NUM")
    @Expose
    private String tel_num;

    @SerializedName("STATE")
    @Expose
    private String state;

    @SerializedName("STATE_CD")
    @Expose
    private String state_cd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_cd() {
        return state_cd;
    }

    public void setState_cd(String state_cd) {
        this.state_cd = state_cd;
    }
}
