package com.example.multimedia.juniorseoul.Classess;

import android.graphics.Bitmap;

public class KidsCafeListItem {
    private String name;
    private String address;
    private Bitmap bitmap;
    private float rate;

    public KidsCafeListItem(){

    }
    public KidsCafeListItem(String name, float rate){
        this.name = name;
        this.rate = rate;
    }

    public KidsCafeListItem(String name, String address, float rate){
        this.name = name;
        this.address = address;
        this.rate = rate;
    }

    public KidsCafeListItem(String name, Bitmap bitmap, float rate) {
        this.name = name;
        this.bitmap = bitmap;
        this.rate = rate;
    }

    public KidsCafeListItem(String name, String address, Bitmap bitmap, float rate) {
        this.name = name;
        this.bitmap = bitmap;
        this.rate = rate;
        this.address = address;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
