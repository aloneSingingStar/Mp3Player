package com.founder.mp3player.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.founder.mp3player.R;
import com.founder.mp3player.model.Mp3Info;
import com.founder.mp3player.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 本地音乐列表，有BUG[在Remote下载玩一首歌后，点击Local面板后不显示]
 * Created by Administrator on 2015/7/7.
 */
public class LocalMp3ListActivity extends ListActivity {
    private  List<Mp3Info> mp3InfoList;
    private Mp3Info mp3Info;
    private  SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_locallist);
//        onResume();
        getFile();
    }

    /**
     * onResume() 在 Activity 从 Pause 状态转换到 Active 状态时被调用
     * Paused状态： 当 Activity 被另一个透明或者 Dialog 样式的 Activity 覆盖时的状态。此时它依然与窗口管理器保持连接，系统继续维护其内部状态，所以它仍然可见，但它已经失去了焦点故不可与用户交互
     * TabActivity里的两个ListActivity是以FrameLayout布局的，所以一个处于活动状态时，另一个就处于Pause状态
     */
    @Override
    protected void onResume() {
        super.onResume();
        getFile();
        simpleAdapter.notifyDataSetChanged();
    }

    public void getFile(){
        FileUtils fileUtils=new FileUtils();
        mp3InfoList=fileUtils.getMp3Files("mp3");
        List<HashMap<String,String>> mapList=new ArrayList<HashMap<String,String>>();
        for (Iterator iterator=mp3InfoList.iterator();iterator.hasNext();){
            mp3Info=(Mp3Info)iterator.next();
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("mp3_name",mp3Info.getMp3Name());
            map.put("mp3_size",mp3Info.getMp3Size());
            mapList.add(map);
        }
         simpleAdapter=new SimpleAdapter(this,mapList,R.layout.mp3info_local_item,new String[]{"mp3_name","mp3_size"},new int[]{R.id.mp3_name,R.id.mp3_size});
        setListAdapter(simpleAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
       mp3Info= mp3InfoList.get(position);
        Intent intent=new Intent(this,PlayerActivity.class);
        intent.putExtra("mp3Info",mp3Info);
        startActivity(intent);
    }
}
