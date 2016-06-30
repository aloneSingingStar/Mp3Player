package com.founder.mp3player.event;

/**
 * Created by Administrator on 2015/8/11.
 */
public class UpdateNavigationBarTitleEvent {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UpdateNavigationBarTitleEvent(String title){this.title=title;}
}
