package com.founder.mp3player.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.founder.mp3player.R;
import com.founder.mp3player.adapter.LiteratureGridViewAdapter;
import com.founder.mp3player.model.Literature;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义 文学Fragment
 * Created by Administrator on 2015/7/17.
 */
public class LiteratureFragment extends BasicReadFragment {
    private int[] imageid=new int[]{R.drawable.chaijing_kanjian,R.drawable.baiyansong_tongbingkuaile,R.drawable.baiyansong_xingzouzai,R.drawable.dazhongma_jidushan,R.drawable.yuguo_bali,R.drawable.luyao_pingfan,R.drawable.yuqiuyu_qiannian,R.drawable.yuqiuyu_shuangleng,R.drawable.yuqiuyu_xingzhe};
    private String[] title=new String[]{"看见-柴静","痛并快乐着-白岩松","行走在爱与恨之间-白岩松","基督山伯爵-大仲马","巴黎圣母院-雨果","平凡的世界-路遥","千年一叹-余秋雨","霜冷长河-余秋雨","行者无疆-余秋雨"};
    private  Literature literature=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_read_literature, container, false);
        List<Literature> literList=new ArrayList<Literature>();
        for (int i=0;i<imageid.length;i++){
            //封装Literature实体数据
             literature=new Literature(title[i],imageid[i]);
            literList.add(literature);
        }
        LiteratureGridViewAdapter literatureGridViewAdapter=new LiteratureGridViewAdapter(getActivity(),literList);
        GridView gridView=(GridView)root.findViewById(R.id.emotion_litera_gridview);
        gridView.setAdapter(literatureGridViewAdapter);
        return  root;
    }
}
