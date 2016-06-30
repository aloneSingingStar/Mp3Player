package com.founder.mp3player.service;




import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;

import com.founder.mp3player.constant.AppConstant;
import com.founder.mp3player.model.Mp3Info;

import java.io.File;

public class PlayerService extends Service {
    private String path;
    private MediaPlayer mediaPlayer = null;

    //播放状态
    private boolean isPlaying = false;
    private boolean isPause = false;
    private boolean isReleased = false;

    private boolean thread1Disable = false;
    private boolean thread2Disable = false;

    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Mp3Info mp3Info = (Mp3Info) intent.getSerializableExtra("mp3Info");
        int MSG = intent.getIntExtra("MSG", 0);
        //通过文件名来找到文件路径
        path = getMp3path(mp3Info);
//        SharedPreferences preferences = getApplicationContext().getSharedPreferences("mp3play", Context.MODE_PRIVATE);
        //startId如果相等，继续播放本首歌曲
//        if (preferences.getInt("LaststartId", 1)%startId==0) {
        if (startId%2==1) {
            //开启播放线程

            thread1Disable=false;
            thread2Disable=true;
            PlayThread playThread = new PlayThread(mp3Info, MSG, path);
            Thread thread1 = new Thread(playThread);
            thread1.start();
        }//如果StartId不相等，就终止上一个线程，然后开启另外一个播放线程
        else {
            thread2Disable=false;
            thread1Disable=true;
            PlayNextThread nextThread=new PlayNextThread(mp3Info, MSG, path);
            Thread thread2 = new Thread(nextThread);
            thread2.start();

        }
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("LaststartId", startId);
        return super.onStartCommand(intent, flags, startId);
    }

    private String getMp3path(Mp3Info mp3Info) {
        String SDCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
        path = SDCardRoot + File.separator + "mp3" + File.separator + mp3Info.getMp3Name();
        return path;
    }

    class PlayThread implements Runnable {
        private Mp3Info mp3Info;
        private int MSG;
        private String path;

        public PlayThread(Mp3Info mp3Info, int msg, String path) {
            this.mp3Info = mp3Info;
            this.MSG = msg;
            this.path = path;
        }

        @Override
        public void run() {
            while(!thread1Disable) {
                playMedia();
            }
        }

        private void playMedia() {

            //执行播放功能
            if (mp3Info != null) {
                if (MSG == AppConstant.PlayMsg.PLAY_MSG) {
                    //如果是暂停，则点击后播放
                    if (!isPlaying) {
                        //播放文件
//                         mediaPlayer= MediaPlayer.create(this, Uri.parse("file://"+path));
                        mediaPlayer = MediaPlayer.create(PlayerService.this, Uri.parse("file://" + path));
                        mediaPlayer.setLooping(false);
                        mediaPlayer.start();
                        isPlaying = true;
                        isReleased = false;
                    }
                } else if (MSG == AppConstant.PlayMsg.PAUSE_MSG) {
                    if (mediaPlayer != null) {
                        if (!isReleased) {
                            if (!isPause) {
                                mediaPlayer.pause();
                                isPause = true;
                                isPlaying = true;
                            } else {
                                mediaPlayer.start();
                                isPause = false;
                            }
                        }
                    }
                } else if (MSG == AppConstant.PlayMsg.STOP_MSG) {
                    //如果在播放状态，则点击后停止
                    if (mediaPlayer != null) {
                        if (isPlaying) {
                            if (!isReleased) {
                                mediaPlayer.stop();
                                mediaPlayer.release();
                                isReleased = true;
                            }
                            isPlaying = false;
                        }
                    }
                }
            }
        }
    }

     class PlayNextThread implements Runnable{
         private Mp3Info mp3Info;
         private int MSG;
         private String path;

         PlayNextThread(Mp3Info mp3Info, int MSG, String path) {
             this.mp3Info = mp3Info;
             this.MSG = MSG;
             this.path = path;
         }

         @Override
        public void run() {
             while(!thread2Disable) {
                 playMedia();
             }
        }

         private void playMedia() {
             //执行播放功能
             if (mp3Info != null) {
                 if (MSG == AppConstant.PlayMsg.PLAY_MSG) {
                     //如果是暂停，则点击后播放
                     if (!isPlaying) {
                         //播放文件
//                         mediaPlayer= MediaPlayer.create(this, Uri.parse("file://"+path));
                         mediaPlayer = MediaPlayer.create(PlayerService.this, Uri.parse("file://" + path));
                         mediaPlayer.setLooping(false);
                         mediaPlayer.start();
                         isPlaying = true;
                         isReleased = false;
                     }
                 } else if (MSG == AppConstant.PlayMsg.PAUSE_MSG) {
                     if (mediaPlayer != null) {
                         if (!isReleased) {
                             if (!isPause) {
                                 mediaPlayer.pause();
                                 isPause = true;
                                 isPlaying = true;
                             } else {
                                 mediaPlayer.start();
                                 isPause = false;
                             }
                         }
                     }
                 } else if (MSG == AppConstant.PlayMsg.STOP_MSG) {
                     //如果在播放状态，则点击后停止
                     if (mediaPlayer != null) {
                         if (isPlaying) {
                             if (!isReleased) {
                                 mediaPlayer.stop();
                                 mediaPlayer.release();
                                 isReleased = true;
                             }
                             isPlaying = false;
                         }
                     }
                 }
             }
         }
     }
}
