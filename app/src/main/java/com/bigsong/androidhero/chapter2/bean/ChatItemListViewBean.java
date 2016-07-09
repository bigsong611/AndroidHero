package com.bigsong.androidhero.chapter2.bean;

import android.graphics.Bitmap;

/**
 * Created by BigSong on 16/7/3.
 */
public class ChatItemListViewBean {
    private int type;
    private String text;
    private Bitmap icon;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public ChatItemListViewBean(int type, String text, Bitmap icon) {
        this.type = type;
        this.text = text;
        this.icon = icon;
    }
}
