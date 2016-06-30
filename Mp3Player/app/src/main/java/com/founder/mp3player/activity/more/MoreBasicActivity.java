package com.founder.mp3player.activity.more;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.founder.mp3player.controller.ListenerController;
import com.founder.mp3player.event.ToastShowEvent;

import de.greenrobot.event.EventBus;

/**
 * 继承自FragmentActivity、使用EventBus框架注册事件的基类
 * Created by Administrator on 2015/7/17.
 */
public class MoreBasicActivity extends FragmentActivity {
    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
//        EventBus.getDefault().unregister(this);
        super.onPause();
    }

     protected ProgressDialog progressDialog;
    public void onEvent(ToastShowEvent event) {
        Toast.makeText(this, event.getContent(), Toast.LENGTH_LONG).show();
    }
}
