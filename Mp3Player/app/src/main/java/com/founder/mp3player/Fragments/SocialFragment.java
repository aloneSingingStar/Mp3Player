package com.founder.mp3player.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.founder.mp3player.R;

/**
 * 自定义 社会Fragment
 * Created by Administrator on 2015/7/17.
 */
public class SocialFragment extends BasicReadFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_read_social, container, false);
        return  root;
    }
}
