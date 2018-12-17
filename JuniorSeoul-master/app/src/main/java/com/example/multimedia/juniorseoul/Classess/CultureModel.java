package com.example.multimedia.juniorseoul.Classess;

public class CultureModel {
    private String title;
    private String place;
    private String time;

    public CultureModel(String title, String place, String time) {
        this.title = title;
        this.place = place;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
