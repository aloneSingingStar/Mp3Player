package com.founder.mp3player.event;

import android.support.v4.app.Fragment;

/**
 * Created by xieyanbni on 2015/8/12.
 */
public class ShowFragmentEvent {
    Fragment fragment;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public ShowFragmentEvent(Fragment fragment) {
        this.fragment=fragment;
    }
}
