package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CafeList {

    @SerializedName("LONGITUDE")
    @Expose
    private String longitude;

    @SerializedName("LATITUDE")
    @Expose
    private String latitude;

    @SerializedName("NAME")
    @Expose
    private String name;

    @SerializedName("TEL")
    @Expose
    private String tel;

    @SerializedName("ADDR")
    @Expose
    private String address;

    @SerializedName("RATING")
    @Expose
    private double rating;

    @SerializedName("IMAGE_URL")
    @Expose
    private String image_url;

    @SerializedName("KIDS_ID")
    @Expose
    private int kids_id;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getKids_id() {
        return kids_id;
    }

    public void setKids_id(int kids_id) {
        this.kids_id = kids_id;
    }

}
