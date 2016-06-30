package com.founder.mp3player.Fragments.more;

import android.support.v4.app.Fragment;

import de.greenrobot.event.EventBus;

/**
 * more的Fragment的基类,使用EventBus框架注册事件
 * Created by Administrator on 2015/7/17.
 */
public  class MoreBasicFragment extends Fragment {
    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }
}
