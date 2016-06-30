package com.founder.mp3player.controller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;

import com.founder.mp3player.R;
import com.founder.mp3player.activity.MainActivity;
import com.founder.mp3player.adapter.ListenerControllerAdapter;

/**
 * Created by Administrator on 2015/7/17.
 */
public class MainController extends ListenerControllerAdapter implements View.OnClickListener,RadioGroup.OnCheckedChangeListener,AdapterView.OnItemClickListener{
   private MainActivity mainActivity;
    /**
     * ListenerController
     * @param i
     * @param view
     */
    @Override
    public void register(int i, View view) {
        mainActivity=(MainActivity)view.getContext();
        switch (i){
            case ON_CLICK:{
                view.setOnClickListener(this);
                break;
            }
            case ON_CHECK:{
                ((RadioGroup)view).setOnCheckedChangeListener(this);
                break;
            }
        }
    }

    /**
     * View.OnClickListener
     * @param v
     */
    @Override
    public void onClick(View v) {
        mClickLinister(v.getId());
    }

    private void mClickLinister(int id) {
        switch (id){
            case R.id.re_reading:
                if(!MainActivity.re_reading.isChecked()){
                    return;
                }
                if(View.GONE!=mainActivity.html5View.getVisibility()||View.GONE!=mainActivity.musicView.getVisibility()||View.GONE!=mainActivity.moreView.getVisibility()){
                    mainActivity.html5View.setVisibility(View.GONE);
                    mainActivity.musicView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.GONE);
                    mainActivity.readingView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.re_music:
                if (!mainActivity.re_music.isChecked()){
                    return;
                }
                if (View.GONE!=mainActivity.html5View.getVisibility()||View.GONE!=mainActivity.readingView.getVisibility()||View.GONE!=mainActivity.moreView.getVisibility()){
                    mainActivity.html5View.setVisibility(View.GONE);
                    mainActivity.readingView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.GONE);
                    mainActivity.musicView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.re_video:
                if (!mainActivity.re_video.isChecked()){
                    return;
                }
                if (View.GONE!=mainActivity.musicView.getVisibility()||View.GONE!=mainActivity.readingView.getVisibility()||View.GONE!=mainActivity.moreView.getVisibility()){
                    mainActivity.html5View.setVisibility(View.VISIBLE);
                    mainActivity.readingView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.GONE);
                    mainActivity.musicView.setVisibility(View.GONE);
                }
                break;
            case R.id.re_sport:
                if (!mainActivity.re_sport.isChecked()){
                    return;
                }
                if (View.GONE!=mainActivity.musicView.getVisibility()||View.GONE!=mainActivity.readingView.getVisibility()||View.GONE!=mainActivity.moreView.getVisibility()){
                    mainActivity.html5View.setVisibility(View.VISIBLE);
                    mainActivity.readingView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.GONE);
                    mainActivity.musicView.setVisibility(View.GONE);
                }
                break;
            case R.id.re_cook:
                if (!mainActivity.re_cook.isChecked()){
                    return;
                }
                if (View.GONE!=mainActivity.musicView.getVisibility()||View.GONE!=mainActivity.readingView.getVisibility()||View.GONE!=mainActivity.moreView.getVisibility()){
                    mainActivity.html5View.setVisibility(View.VISIBLE);
                    mainActivity.readingView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.GONE);
                    mainActivity.musicView.setVisibility(View.GONE);
                }
                break;
            case R.id.re_other:
                if (!mainActivity.re_other.isChecked()){
                    return;
                }
                if (View.GONE!=mainActivity.musicView.getVisibility()||View.GONE!=mainActivity.readingView.getVisibility()||View.GONE!=mainActivity.html5View.getVisibility()){
                    mainActivity.html5View.setVisibility(View.GONE);
                    mainActivity.readingView.setVisibility(View.GONE);
                    mainActivity.moreView.setVisibility(View.VISIBLE);
                    mainActivity.musicView.setVisibility(View.GONE);
                }
                break;
        }
    }

    /**
     * 按钮选中状态改变时处理，暂时不做
     * RadioGroup.OnCheckedChangeListener
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    /**
     * AdapterView.OnItemClickListener
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
