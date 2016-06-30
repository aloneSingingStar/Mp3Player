package com.founder.mp3player.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;

import com.founder.mp3player.R;
import com.founder.mp3player.activity.NotificationActivity;
import com.founder.mp3player.download.HttpDownloader;
import com.founder.mp3player.model.Mp3Info;

/**
 * Created by Administrator on 2015/7/5.
 */
public class DownloadService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Mp3Info mp3Info=(Mp3Info)intent.getSerializableExtra("mp3Info");
        DownLoadThread downLoadThread=new DownLoadThread(mp3Info);
        Thread thread=new Thread(downLoadThread);
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }
    class DownLoadThread implements Runnable{
        private  Mp3Info mp3Info=null;

        DownLoadThread(Mp3Info mp3Info) {
            this.mp3Info = mp3Info;
        }

        @Override
        public void run() {
            //下载MP3文件
            String mp3Url="http://192.168.135.92:8080/mp3/"+mp3Info.getMp3Name();
            String  resultMessage=null;
            HttpDownloader httpDownloader=new HttpDownloader();
            //将文件下载，并存储到SD卡中
           int result= httpDownloader.downFile(mp3Url,"mp3",mp3Info.getMp3Name());
            if(result==-1){
                resultMessage="下载失败";
            }else if(result==1){
                resultMessage="文件已经存在，不需要重复下载";
            }else if(result==0){
                resultMessage="文件下载成功";
            }
            //使用Notification提示客户下载结果
            notificationMethod(resultMessage);
        }
    }
    public void notificationMethod(String  resultMessage){
        //从系统获得通知管理器NotificationManager，它是一个系统Service。
        //其中创建的 manager 对象负责“发出”与“取消”  Notification。
        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //创建 Notification ，
        // 参数依次为：icon的资源id，在状态栏上展示的滚动信息，时间。
        // 其中创建的 notification 对象用来描述出现在系统通知栏的信息，
        // 之后我们将会看到会在 notification 对象上设置点击此条通知发出的Intent
//        Notification notification=new Notification(R.mipmap.Notification_logo,"通知栏消息",System.currentTimeMillis());

        //兼容Android 2.x版本是的处理方式
        Notification notification=new Notification();
        notification.icon=R.mipmap.notification_logo;
        notification.tickerText="TickerText:您有新短消息，请注意查收";
        notification.when=System.currentTimeMillis();
        //添加声音提示
        notification.defaults=Notification.DEFAULT_SOUND;
        // audioStreamType的值必须AudioManager中的值，代表着响铃的模式
        notification.audioStreamType= AudioManager.ADJUST_LOWER;
        Intent intent=new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        notification.setLatestEventInfo(this,"下载状态",resultMessage,pendingIntent);
        manager.notify(1,notification);
//        notification.setLatestEventInfo(this,"");
    }
}
