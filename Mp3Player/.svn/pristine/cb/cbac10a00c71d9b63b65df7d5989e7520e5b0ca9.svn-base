package com.founder.mp3player.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.founder.mp3player.Fragments.BasicReadFragment;

import java.util.List;

/**
 *读物模块所有Fragment的适配器
 * Created by Administrator on 2015/7/17.
 */
public class ReadFragmentViewPageAdapter extends FragmentPagerAdapter {
    List<BasicReadFragment> readFragments;
    public ReadFragmentViewPageAdapter(FragmentManager fm, List<BasicReadFragment> readFragments) {
        super(fm);
        this.readFragments=readFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return readFragments.get(position);
    }

    @Override
    public int getCount() {
        return readFragments.size();
    }
}
