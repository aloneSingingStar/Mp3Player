package com.founder.mp3player.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.model.Literature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *自定义 GridView适配器
 * Created by Administrator on 2015/7/21.
 */
public class LiteratureGridViewAdapter extends MyBaseAdapter {
    private List<Literature> info;
    private Context context;
    //键是postion,值是View
    private Map<Integer,View> columnViews=new HashMap<Integer,View>();
    public LiteratureGridViewAdapter(Context context,List<Literature> info){
        this.context=context;
        this.info=info;
    }
    @Override
    public int getCount() {
        return info.size();
    }

    @Override
    public Object getItem(int position) {
        return info.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View columnview=columnViews.get(position);
        //如果缓存中为空
        if (columnview==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            columnview=layoutInflater.inflate(R.layout.emotion_literature_gridview_item,null);
            ImageView imageView=(ImageView)columnview.findViewById(R.id.emotion_gridview_literature_image);
            TextView textView=(TextView)columnview.findViewById(R.id.emotion_gridview_literature_title);
            imageView.setImageResource(info.get(position).getImageId());
            textView.setText(info.get(position).getTitle());
            //添加到缓存
            columnViews.put(position,columnview);
        }
        //缓存不为空就直接返回
        return columnview;
    }
}
