package com.founder.mp3player.Fragments.more;

import android.view.View;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.event.BackEvent;
import com.founder.mp3player.event.UpdateNavigationBarTitleEvent;

import de.greenrobot.event.EventBus;

/**内容部分Fragment的基类（主要包括连个方法：更新标题、改变选择模块及选中模块的颜色和选中的状态）
 * Created by xieyanbin on 15/8/2.
 */
public class ContentFragment extends MoreBasicFragment {
    TextView subTitle;
    int redColor;
    String titleStr;
    protected void initSubtitle(View root, int tv_checkPhone){
        redColor= getResources().getColor(R.color.red_openaccount);
        subTitle=(TextView)root.findViewById(tv_checkPhone);
        subTitle.setTextColor(redColor);
    }
    protected void updateTitle(int title){
        titleStr=getResources().getString(title);
        EventBus.getDefault().post(new UpdateNavigationBarTitleEvent(titleStr));
    }

    /**
     * 每个注册了EventBus的组件中必须有一个onEvent开头的、非静态的、public权限以及仅仅只有一个参数 的方法，也就是没有类似于：public void onEvent**（Object arg)这样的方法，导致出现了这个错误。
     de.greenrobot.event.EventBusException: Subscriber class com.founder.mp3player.Fragments.more.NavigationBarFragment has no public methods called onEvent
     * @param event
     */
    public void onEvent(BackEvent event) {

    }
}
