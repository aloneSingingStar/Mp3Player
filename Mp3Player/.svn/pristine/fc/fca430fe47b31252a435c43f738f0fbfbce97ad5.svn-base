package com.founder.mp3player.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/20.
 */
public class Emotion implements Serializable {
    private static final Long serialVersionUID=1L;

    public Emotion() {
    }

    public Emotion(int id, String author, String content, String imgUrl) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    private int id;
    private String author;
    private String content;
    private String imgUrl;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emotion{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
