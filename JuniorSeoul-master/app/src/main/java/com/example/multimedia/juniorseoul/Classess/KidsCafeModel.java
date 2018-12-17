package com.example.multimedia.juniorseoul.Classess;

public class KidsCafeModel {

    private String name;
    private String address;
    private String phoneNum;
    private double latitude;
    private double longitude;

    //getter, setter, constructor 만들자
    public KidsCafeModel(String name, String address, String phoneNum, double latitude, double longitude){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
}
