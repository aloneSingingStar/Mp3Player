package com.founder.mp3player.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *自定义ViewPager,可实现自定义其滚动功能
 * Created by Administrator on 2015/7/16.
 */
public class ReadFragmentViewPager extends ViewPager {
    // 布尔值 --决定viewpage的滑动效果 false不滑动
    private boolean enabled=true;
    public ReadFragmentViewPager(Context context) {
        super(context);
    }

    public ReadFragmentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    /**\
     * oniterceptTouchEvent是判断当前viewgroup是否拦截此touch事件，
     * 如果返回false表示不拦截，事件继续向下传递
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
