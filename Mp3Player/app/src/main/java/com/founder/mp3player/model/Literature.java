package com.founder.mp3player.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/21.
 */
public class Literature implements Serializable{
    public static final long serialVersion=1L;
    private String title;
    private int imageId;

    public Literature(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
