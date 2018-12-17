package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MuseumArtMemorialList {
    @SerializedName("CHILD_PAY")
    @Expose
    private String child_pay;

    @SerializedName("NAME")
    @Expose
    private String name;

    @SerializedName("STATE_NM")
    @Expose
    private String state_name;

    @SerializedName("TEENAGER_PAY")
    @Expose
    private String teenager_pay;

    @SerializedName("ADDR")
    @Expose
    private String address;

    @SerializedName("OPER_PAGE")
    @Expose
    private String oper_page;

    @SerializedName("OPER_TEL")
    @Expose
    private String oper_tel;

    @SerializedName("LONGITUDE")
    @Expose
    private String longitude;

    @SerializedName("OPER_NM")
    @Expose
    private String oper_name;

    @SerializedName("LATITUDE")
    @Expose
    private String latitude;

    @SerializedName("ADULT_PAY")
    @Expose
    private String adult_pay;

    public String getChild_pay() {
        return child_pay;
    }

    public void setChild_pay(String child_pay) {
        this.child_pay = child_pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getTeenager_pay() {
        return teenager_pay;
    }

    public void setTeenager_pay(String teenager_pay) {
        this.teenager_pay = teenager_pay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOper_page() {
        return oper_page;
    }

    public void setOper_page(String oper_page) {
        this.oper_page = oper_page;
    }

    public String getOper_tel() {
        return oper_tel;
    }

    public void setOper_tel(String oper_tel) {
        this.oper_tel = oper_tel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOper_name() {
        return oper_name;
    }

    public void setOper_name(String oper_name) {
        this.oper_name = oper_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAdult_pay() {
        return adult_pay;
    }

    public void setAdult_pay(String adult_pay) {
        this.adult_pay = adult_pay;
    }
}
