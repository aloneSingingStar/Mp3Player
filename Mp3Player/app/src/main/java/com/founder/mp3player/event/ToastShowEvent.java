package com.founder.mp3player.event;


/**
 * Created by xieyanbin on 15/8/2.
 */
public class ToastShowEvent {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ToastShowEvent(String content) {
        this.content = content;
    }
}
