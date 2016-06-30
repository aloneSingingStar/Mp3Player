package com.founder.mp3player.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.founder.mp3player.R;
import com.founder.mp3player.model.Mp3Info;
import com.founder.mp3player.service.PlayerService;

import java.io.File;

public class PlayerActivity extends Activity implements View.OnClickListener{
    private  ImageButton beginBtn;
    private  ImageButton pauseBtn;
    private  ImageButton stopBtn;
    //播放状态
    private  boolean isPlaying=false;
    private boolean isPause=false;
    private boolean  isReleased=false;

    private MediaPlayer mediaPlayer=null;
    private Mp3Info mp3Info;
    private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        serviceIntent=new Intent(this, PlayerService.class);
        init();
        serviceIntent.putExtra("mp3Info",mp3Info);
    }
    private void init() {
        Intent intent=getIntent();
        mp3Info=(Mp3Info)intent.getSerializableExtra("mp3Info");
        this.beginBtn=(ImageButton)findViewById(R.id.begin);
        this.pauseBtn=(ImageButton)findViewById(R.id.pause);
        this.stopBtn=(ImageButton)findViewById(R.id.stop);
        this.beginBtn.setOnClickListener(this);
        this.pauseBtn.setOnClickListener(this);
        this.stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.begin:play();startService(serviceIntent);break;
            case R.id.pause:pause();startService(serviceIntent);break;
            case R.id.stop:stop();startService(serviceIntent);break;
            default:break;
        }
    }

    private void stop() {
        serviceIntent.putExtra("MSG",3);
    }

    private void pause() {
        serviceIntent.putExtra("MSG",2);
    }

    private void play() {
        serviceIntent.putExtra("MSG",1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
