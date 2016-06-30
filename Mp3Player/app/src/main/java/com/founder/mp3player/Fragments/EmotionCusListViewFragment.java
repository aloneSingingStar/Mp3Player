package com.founder.mp3player.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.founder.mp3player.R;
import com.founder.mp3player.adapter.EmotionCusListViewAdapter;
import com.founder.mp3player.adapter.EmotionListAdapter;
import com.founder.mp3player.db.EmotionInfoDao;
import com.founder.mp3player.model.Emotion;
import com.founder.mp3player.views.listviews.CustomListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**自定义 情感Fragment
 * Created by Administrator on 2015/7/17.
 */
public class EmotionCusListViewFragment extends BasicReadFragment implements CustomListView.OnRefreshListener,AdapterView.OnItemClickListener,View.OnClickListener {
    private CustomListView listView;
    private List<Emotion> info = new ArrayList<Emotion>();
    private EmotionInfoDao emotionInfoDao;
    private EmotionCusListViewAdapter emotionCusListViewAdapter;
    private View header;
    private int limit=5;
    private int offset=0;
    private int currentPage=0;
    File cache;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        Log.i("onCreateView", "1------------>>>onCreate");
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isHidden")) {
                getFragmentManager().beginTransaction().hide(this).commit();
            }
        }
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        emotionInfoDao=new EmotionInfoDao(getActivity());
        cache=new File(Environment.getExternalStorageDirectory(),"AsyncCache");
        if (!cache.exists()){
            cache.mkdirs();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (info!=null){

        }
        super.onSaveInstanceState(outState);
//        outState.putBoolean("isHidden", this.isHidden());
//        if (info!=null){
//            outState.putParcelableArrayList("info", (ArrayList<? extends android.os.Parcelable>) info);
//        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Log.i("onCreateView", "2------------>>>onCreateView");
        View root = inflater.inflate(R.layout.fragment_read_emotion, container, false);
        findViews(root);
        initData();
        setListener();

        return  root;
    }

    private void initData() {
        info.clear();
        //初始化5条数据
        info.addAll(emotionInfoDao.query(limit,offset));
        emotionCusListViewAdapter=new EmotionCusListViewAdapter(getActivity(),info,cache);
        listView.setAdapter(emotionCusListViewAdapter);
    }

    private void setListener() {
        listView.setOnItemClickListener(this);
        listView.setonRefreshListener(this);
    }

    private void findViews(View root) {
        listView=(CustomListView) root.findViewById(R.id.option_CustomListView);           //下拉刷新页面
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onRefresh() {
        currentPage++;
        offset=currentPage*limit;
        //使用这中的话，图片位置会混乱
//        info.addAll(0, emotionInfoDao.query(limit,offset));
        info.addAll(emotionInfoDao.query(limit,offset));
        listView.onRefreshComplete();
        emotionCusListViewAdapter.notifyDataSetChanged();

        Log.i("onRefresh", "------------->>>");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            //初始化数据

        }else {
            if(listView!=null){
                listView.onRefreshComplete();
            }
        }
    }
}
