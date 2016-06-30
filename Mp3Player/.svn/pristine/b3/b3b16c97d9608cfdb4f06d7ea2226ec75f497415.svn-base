package com.founder.mp3player.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.async.AsyncImageLoader;
import com.founder.mp3player.callback.CallbackImpl;
import com.founder.mp3player.model.Emotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *EmotionList适配器
 * Created by Administrator on 2015/7/20.
 */
public   class EmotionListAdapter extends MyBaseAdapter {
    private Context context;
    private List<Emotion> info=null;
    private Map<Integer,View> rowViews=new HashMap<Integer,View>();
    private AsyncImageLoader imageLoader=new AsyncImageLoader();
    public EmotionListAdapter(Context context,List<Emotion> info) {
        this.context = context;
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
        View rowView=rowViews.get(position);
        if (rowView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            rowView=layoutInflater.inflate(R.layout.emotion_listview_item,null);
            TextView authorview=(TextView)rowView.findViewById(R.id.emotion_author);
            TextView contentview=(TextView)rowView.findViewById(R.id.emotion_content);
            ImageView imageview=(ImageView)rowView.findViewById(R.id.emotion_image);
            authorview.setText(info.get(position).getAuthor());
            contentview.setText(info.get(position).getContent());
//            imageview.setImageURI(Uri.parse(info.get(position).getImgUrl()));
//            imageview.setImageBitmap();
            String imageUrl=info.get(position).getImgUrl();
            CallbackImpl callback=new CallbackImpl(imageview);
            Drawable cacheImage=imageLoader.loadDrawable(imageUrl,callback);
            if (cacheImage!=null){
                imageview.setImageDrawable(cacheImage);
            }
            rowViews.put(position,rowView);
        }
        return rowView;
    }
}
