package com.founder.mp3player.activity;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.founder.mp3player.controller.ListenerController;

/**
 * 继承自FragmentActivity、带有注册监听的基类
 * Created by Administrator on 2015/7/17.
 */
public class BasicFragmentActivity extends FragmentActivity {
    public void registerListener(int flag, android.view.View view, ListenerController listenerController){
            listenerController.register(flag,view);
    }
}
