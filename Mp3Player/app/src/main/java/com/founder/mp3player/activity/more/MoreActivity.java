package com.founder.mp3player.activity.more;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;

import com.founder.mp3player.Fragments.more.CheckPhoneFragment;
import com.founder.mp3player.Fragments.more.NavigationBarFragment;
import com.founder.mp3player.Fragments.more.SelectDepartmentFragment;
import com.founder.mp3player.R;
import com.founder.mp3player.event.BackEvent;
import com.founder.mp3player.event.ShowFragmentEvent;

import de.greenrobot.event.EventBus;

public class MoreActivity extends MoreBasicActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_account_open);
        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.container_navigationbar, new NavigationBarFragment()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.container_main, new CheckPhoneFragment()).commit();
//            getSupportFragmentManager().beginTransaction().add(R.id.container_main, new SelectDepartmentFragment()).commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if (keyCode==KeyEvent.KEYCODE_BACK)
            if (getSupportFragmentManager().getBackStackEntryCount()>0) {
                getSupportFragmentManager().popBackStack();
            }else {
                finish();
            }

        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    /**
     * 执行 返回事件
     * @param event
     */
    public void onEvent(BackEvent event){
        onPostResume();//解决这个异常：illegalStateException can not perform this action after onsaveinstancestate异常
        if (getSupportFragmentManager().getBackStackEntryCount()>0){
//            把顶部的状态弹出回退堆栈。这个方法是异步执行的。它会按照请求的顺序来执行弹出操作，但是这个操作直到应用程序把控制权返回给事件循环之后，才能够执行这个操作。
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

    /**
     * 执行 显示Fragment的事件
     * @param event
     */
    public void onEvent(ShowFragmentEvent event) throws IllegalAccessException, InstantiationException {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.hide(getSupportFragmentManager().findFragmentById(R.id.container_main));
//        ft.add(R.id.container_main,event.getFragment()).addToBackStack(null).commit();
        ft.add(R.id.container_main,event.getFragment()).addToBackStack(null).commitAllowingStateLoss();//解决这个异常：illegalStateException can not perform this action after onsaveinstancestate异常
    }
}
