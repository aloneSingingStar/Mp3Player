package com.founder.mp3player.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.founder.mp3player.model.Emotion;

import java.util.List;

/**
 *
 * Created by Administrator on 2015/7/30.
 */
public  class BigDataFragment extends Fragment {
    public static final String TAG="bigdataserver";
    private  List<Emotion> info;

    public BigDataFragment(List<Emotion> info) {
        this.info = info;
    }
    public static BigDataFragment newInstance(List<Emotion> info) {
        return new BigDataFragment(info);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    public List<Emotion> getInfoList(){
        return info;
    }
}
