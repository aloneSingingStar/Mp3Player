package com.founder.mp3player.Fragments.more;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.founder.mp3player.R;

/**
 * Created by xieyanbin on 15/7/28.
 */
public class SelectDepartmentFragment extends ContentFragment {
    View root;
    Spinner province;
    Spinner city;
    Spinner department;
    TextView next;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_more_selectdepartment,container,false);
        initView(root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateTitle(R.string.title_openAccount);
    }

    private void initView(View root) {
        province=(Spinner)root.findViewById(R.id.sp_province);
        city=(Spinner)root.findViewById(R.id.sp_city);
        department=(Spinner)root.findViewById(R.id.sp_department);
        next=(TextView)root.findViewById(R.id.tv_next);
        initSubtitle(root,R.id.tv_openAccount);
    }
}