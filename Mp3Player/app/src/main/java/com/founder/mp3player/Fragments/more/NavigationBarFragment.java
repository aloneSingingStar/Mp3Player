package com.founder.mp3player.Fragments.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.event.BackEvent;
import com.founder.mp3player.event.UpdateNavigationBarTitleEvent;

import de.greenrobot.event.EventBus;

/**标题Fragment
 * Created by Administrator on 2015/7/17.
 */
public class NavigationBarFragment extends MoreBasicFragment implements View.OnClickListener{
    View root;
    TextView title;
    TextView back;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_more_navigationbar,container,false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        title=(TextView)root.findViewById(R.id.title);
        back=(TextView)root.findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        back();
    }

    /**
     * 分发返回事件
     */
    public void back() {
        EventBus.getDefault().post(new BackEvent());
    }

    /**
     * 设置标题事件[当内容Fragment改变时，在其OnResume方法中，调用设置标题的方法触发该事件]
     * @param event
     */
    public void onEvent(UpdateNavigationBarTitleEvent event){
        this.title.setText(event.getTitle());
    }
}
