package com.founder.mp3player.controller;

/**
 * Created by Administrator on 2015/7/17.
 */
public interface  ListenerController {
    int NONE = 0;
    int ON_CLICK = 7974913;
    int ON_CHECK = 7974914;
    int ON_SELECT = 7974915;
    int ON_ITEM_CLICK = 7974916;
    int ON_TOUCH = 7974917;
    int ON_CHILDCLICK = 7974918;
    int ON_LONGCLICK = 7974919;
    int ON_SCROLLCHANGE = 7974920;
    int ON_MENUITEM_CLICK = 7974921;
    void register(int i, android.view.View view);
}
