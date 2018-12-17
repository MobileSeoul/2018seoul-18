package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NationalTreasureList {
    @SerializedName("LONGITUDE")
    @Expose
    private String longitude;

    @SerializedName("LATITUDE")
    @Expose
    private String latitude;

    @SerializedName("STATE")
    @Expose
    private String state;

    @SerializedName("TRSR_NM_KO")
    @Expose
    private String koreanNm;

    @SerializedName("ADDR")
    @Expose
    private String address;

    @SerializedName("TRSR_GUBUN_NM")
    @Expose
    private String trsr_gubun;

    @SerializedName("TRSR_NM_CHA")
    @Expose
    private String chineseNm;

    @SerializedName("TRSR_NUM")
    @Expose
    private String number;

    @SerializedName("AGE")
    @Expose
    private String age;

    @SerializedName("GUBUN")
    @Expose
    private String gubun;

    @SerializedName("QUANTITY")
    @Expose
    private String quantity;

    @SerializedName("TRSR_ID")
    @Expose
    private int id;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getKoreanNm() {
        return koreanNm;
    }

    public void setKoreanNm(String koreanNm) {
        this.koreanNm = koreanNm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrsr_gubun() {
        return trsr_gubun;
    }

    public void setTrsr_gubun(String trsr_gubun) {
        this.trsr_gubun = trsr_gubun;
    }

    public String getChineseNm() {
        return chineseNm;
    }

    public void setChineseNm(String chineseNm) {
        this.chineseNm = chineseNm;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
