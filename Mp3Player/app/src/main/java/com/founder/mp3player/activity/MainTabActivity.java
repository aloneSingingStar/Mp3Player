package com.founder.mp3player.activity;


import android.app.Dialog;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.callback.DialogCallbackImpl;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2015/7/7.
 */
public class MainTabActivity extends TabActivity{
    public static long sTime;
    private  String MSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintab);
//        sTime=new Date().getTime();
//        //设置启动图
//        final ImageView imageView=new ImageView(getApplicationContext(),null);
//        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        imageView.setBackgroundResource(R.drawable.start_logo);
//        final Dialog dialog=new Dialog(this,R.style.launch_dialog);
//        dialog.setContentView(imageView);
//        dialog.show();

        TabHost tabHost=getTabHost();
//        tabHost.setup();
        Intent remoteIntent=new Intent(this,Mp3ListActivity.class);
        TabHost.TabSpec remoteSpec=tabHost.newTabSpec("Remote");
        Resources resources=getResources();
//        remoteSpec.setIndicator("Remote",resources.getDrawable(android.R.drawable.stat_sys_upload));
        remoteSpec.setIndicator(createTabView("Remote"));
        remoteSpec.setContent(remoteIntent);
        tabHost.addTab(remoteSpec);

        Intent localIntent=new Intent(this,LocalMp3ListActivity.class);
        TabHost.TabSpec localSpec=tabHost.newTabSpec("Local");
//        localSpec.setIndicator("Local",resources.getDrawable(android.R.drawable.stat_sys_download));
        localSpec.setIndicator(createTabView("Local"));
        localSpec.setContent(localIntent);
        tabHost.addTab(localSpec);

//        tabHost.setCurrentTab(0);

//        //3秒后关闭启动图
//        Timer timer=new Timer();
//        timer.schedule(new dismisTask(dialog),3000);

    }

    private View createTabView(String name) {
//        View view=getLayoutInflater().inflate(R.layout.tab_style,null);
        LayoutInflater inflater=LayoutInflater.from(this);
        View tabView=inflater.inflate(R.layout.tab_style,null);
        TextView textView=(TextView)tabView.findViewById(R.id.tab_name);
        textView.setText(name);
        return tabView;
    }


    Handler myhandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1){
//                case 0:DialogCallbackImpl dialogCallback=new DialogCallbackImpl((Dialog)msg.obj);
//                    dialogCallback.dismissDialog((Dialog)msg.obj);
                case 0:((Dialog)msg.obj).dismiss();
            }
        }
    };
    public interface dialogCallback{
        public void dismissDialog(Dialog dialog);
    }

    private class dismisTask extends TimerTask {
        private Dialog dialog;

        private dismisTask(Dialog dialog) {
            this.dialog = dialog;
        }

        @Override
        public void run() {
                    Message message=myhandle.obtainMessage(0,dialog);
                    myhandle.sendMessage(message);
        }
    }
}
