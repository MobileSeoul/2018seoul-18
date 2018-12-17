package com.example.multimedia.juniorseoul.Classess;

public class TreasureListItem {
    private int img;
    private String kr_name;
    private String ch_name;
    private String age;
    private String num;

    public TreasureListItem(int img, String kr_name, String ch_name, String age, String num) {

        this.img = img;
        this.kr_name = kr_name;
        this.ch_name = ch_name;
        this.age = age;
        this.num = num;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getKr_name() {
        return kr_name;
    }

    public void setKr_name(String kr_name) {
        this.kr_name = kr_name;
    }

    public String getCh_name() {
        return ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
