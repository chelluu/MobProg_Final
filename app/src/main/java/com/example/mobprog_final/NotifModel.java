package com.example.mobprog_final;

public class NotifModel {
    private String title, text;
    private int img;

    public NotifModel(String title, String text, int img) {
        this.title = title;
        this.text = text;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
