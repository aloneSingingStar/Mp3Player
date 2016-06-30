package com.founder.mp3player.Fragments;

/**
 * 读物这个模块的所有Fragment的基类
 * Created by Administrator on 2015/7/17.
 */
public class BasicReadFragment extends BasicFragment {
    /**
     * 新版Fragment是否已创建
     */
    protected boolean isLoadFinish = false;
    @Override
    public void setListeners() {
        super.setListeners();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if (!isLoadFinish){
            return;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
