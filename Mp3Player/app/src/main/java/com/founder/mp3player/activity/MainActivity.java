package com.founder.mp3player.activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.founder.mp3player.R;
import com.founder.mp3player.activity.more.MoreActivity;
import com.founder.mp3player.adapter.ListenerControllerAdapter;
import com.founder.mp3player.controller.ListenerController;
import com.founder.mp3player.controller.MainController;

/**
 * 主界面容器
 */
public class MainActivity extends BasicActivity {
    private LayoutInflater inflater;
    //用LocalActivityManager把MainActivity当成一个Activity容器
    private LocalActivityManager  localActivityManager;
    //用来存放转化成View的Activity
    private LinearLayout  content;
    private static  RadioGroup sMenuBar;
    public static RadioButton re_reading, re_music, re_video, re_sport, re_cook, re_other;
    //将Activity转化为一个View对象，然后再放到MainActivity容器中
    //必须是public的，不然在MainController中由于没有传入MainActivity,就不能访问
    public static View readingView;
    public static View html5View;
    public static View moreView;
    public static View musicView;

    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater=getLayoutInflater();
        mainController=new MainController();
        localActivityManager=new LocalActivityManager(this,true);
//        localActivityManager.dispatchCreate(savedInstanceState);
        localActivityManager.dispatchResume();
        findViews();
        setListeners();
        initViews();
    }

    private void initViews() {
        musicView.setVisibility(View.GONE);
        readingView.setVisibility(View.VISIBLE);
        html5View.setVisibility(View.GONE);
        moreView.setVisibility(View.GONE);
        sMenuBar.clearCheck();
        re_reading.setChecked(true);
    }

    private void setListeners() {
        registerListener(ListenerControllerAdapter.ON_CHECK,sMenuBar,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_reading,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_music,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_video,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_sport,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_cook,mainController);
        registerListener(ListenerControllerAdapter.ON_CLICK,re_other,mainController);
    }

    private void findViews() {
         re_reading=(RadioButton)findViewById(R.id.re_reading);
         re_music=(RadioButton)findViewById(R.id.re_music);
         re_video=(RadioButton)findViewById(R.id.re_video);
         re_sport=(RadioButton)findViewById(R.id.re_sport);
         re_cook=(RadioButton)findViewById(R.id.re_cook);
         re_other=(RadioButton)findViewById(R.id.re_other);
        content=(LinearLayout)findViewById(R.id.ll_content);
        sMenuBar=(RadioGroup)findViewById(R.id.rg_bottom_bar);
        //用来存放转化成View的Activity
        Intent intent=new Intent(this,ReadingActivity.class);
        readingView=localActivityManager.startActivity("Reading",intent).getDecorView();
         intent=new Intent(this,Html5Activity.class);
        html5View=localActivityManager.startActivity("HTML5",intent).getDecorView();
//        intent=new Intent(this,MoreActivity.class);
        intent=new Intent(this, MoreActivity.class);
        moreView=localActivityManager.startActivity("More",intent).getDecorView();
        intent=new Intent(this,MainTabActivity.class);
        musicView=localActivityManager.startActivity("Music",intent).getDecorView();
        ViewGroup.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        content.addView(readingView);
        content.addView(html5View);
        content.addView(moreView);
        content.addView(musicView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
