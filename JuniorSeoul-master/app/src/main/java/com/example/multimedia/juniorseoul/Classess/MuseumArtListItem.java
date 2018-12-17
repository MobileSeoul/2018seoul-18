package com.example.multimedia.juniorseoul.Classess;

public class MuseumArtListItem {
    private String name;
    private String state;
    private int img;

    public MuseumArtListItem(String name, String state, int img) {
        this.name = name;
        this.state = state;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
