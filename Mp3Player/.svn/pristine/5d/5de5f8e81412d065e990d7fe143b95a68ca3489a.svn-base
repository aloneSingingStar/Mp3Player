/*
package com.founder.mp3player.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.founder.mp3player.R;
import com.founder.mp3player.activity.ReadingActivity;
import com.founder.mp3player.adapter.EmotionListAdapter;
import com.founder.mp3player.db.EmotionInfoDao;
import com.founder.mp3player.model.Emotion;

import java.util.List;

*自定义 情感Fragment
 * Created by Administrator on 2015/7/17.


public class EmotionFragment extends BasicReadFragment implements AbsListView.OnScrollListener{
    private  ListView listView;
    private List<Emotion> info;
    private EmotionInfoDao emotionInfoDao;
    private EmotionListAdapter emotionListAdapter;
    private View header;
    private int limit=5;
    private int offset=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_read_emotion, container, false);
         header=inflater.inflate(R.layout.header,null);
        listView=(ListView)root.findViewById(R.id.emotion_listview);
        isLoadFinish = true;
        //从数据库中获取info信息
        emotionInfoDao=new EmotionInfoDao(getActivity());

        //        List<Emotion> info=emotionInfoDao.query();
//        listView.setOnScrollListener(new ScrollListener());
        //第一次默认加载前10条
        info=emotionInfoDao.query(limit,offset);
        emotionListAdapter=new EmotionListAdapter(getActivity(),info);

        //添加页脚[必须在setAdapter之前]
        listView.addFooterView(header);
        //添加页眉[必须在setAdapter之前]
        listView.setAdapter(emotionListAdapter);
        listView.removeFooterView(header);
        listView.setOnScrollListener(this);
        return  root;
    }

    Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            info=(List<Emotion>)msg.obj;
            if (listView.getFooterViewsCount()>0){
                listView.removeFooterView(header);
            }
            emotionListAdapter.notifyDataSetChanged();//告诉ListView 数据已经发生改变，要求ListView跟新界面显示
        }
    };
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //            listView.getFirstVisiblePosition();
        //获得当前屏幕最后的item的ID
        int lastItemid=listView.getLastVisiblePosition();
        //滑动到数据的最后一条记录
        if ((lastItemid+1)==totalItemCount){
            if (totalItemCount>0){
//                    listView.addFooterView(header);
                int currentPage=totalItemCount%limit==0?totalItemCount/limit:totalItemCount/limit+1;
                int nextPage=currentPage+1;
                offset=currentPage*limit;
                //加载完成后通知adapter更新数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        info.clear();
                        info=emotionInfoDao.query(limit,offset);
                        info.addAll(info);
                        Message message=mhandler.obtainMessage(0,info);
                        mhandler.sendMessage(message);
                    }
                });



            }

        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){

        }
    }
}
*/
