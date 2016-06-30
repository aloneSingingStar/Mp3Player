package com.founder.mp3player.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.founder.mp3player.Fragments.BasicReadFragment;
import com.founder.mp3player.Fragments.EmotionCusListViewFragment;
import com.founder.mp3player.Fragments.EncyclopediaFragment;
import com.founder.mp3player.Fragments.LearningFragment;
import com.founder.mp3player.Fragments.LiteratureFragment;
import com.founder.mp3player.Fragments.SocialFragment;
import com.founder.mp3player.R;
import com.founder.mp3player.adapter.ReadFragmentViewPageAdapter;
import com.founder.mp3player.utils.ThemeCenter;
import com.founder.mp3player.views.ReadFragmentViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 读物，继承FragmentActivity,里面嵌入多个Fragment
 */
public class ReadingActivity extends BasicFragmentActivity implements View.OnClickListener{
    private final static int TITLENUM = 5;
    //所属包：android.support.v4.app.FragmentManager
    // Fragment管理器
    private FragmentManager fragmentManager;
    private ReadFragmentViewPageAdapter readFragmentViewPageAdapter;//Fragment对应的适配器
    private ReadFragmentViewPager readFragmentViewPager;//包含Fragment的自定义ViewPager
    private View mRoot;//根节点
    public TextView mTvTitle; //标题
    private ImageView mIvSearch;//搜索图标
    private ImageView mIvChangeSkin;//切换皮肤
    private LinearLayout mListTitle;
    private LinearLayout mCursorTrack;
    public ImageView mImageView;// 动画图片
    private TextView[]  raChildTitleArray = new TextView[TITLENUM];//标题数组
    private List<BasicReadFragment> readFragments=new ArrayList<BasicReadFragment>();
    private ThemeCenter themeCenter;
    //白天主题标识
    private final int DAY_THEME=0;
    //夜晚主题标识
    private final int NIGHT_THEME=1;
    //当前主题状态
    private int mTheme=DAY_THEME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if(savedInstanceState!=null){
//            FragmentManager manager = getSupportFragmentManager();
//            manager.popBackStackImmediate(null, 1);
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        //获得Fragment管理器
        fragmentManager=getSupportFragmentManager();
        //初始化主题中心
        themeCenter=ThemeCenter.getInstance(this.getApplicationContext());
        //初始化View
        findViews();
        initData();
        setListeners();
    }

    private void setListeners() {
        //监听换肤事件
        mIvChangeSkin.setOnClickListener(this);
    }

    private void initData() {
//        readFragments.add(new EmotionFragment());
        readFragments.add(new EmotionCusListViewFragment());
        readFragments.add(new SocialFragment());
        readFragments.add(new EncyclopediaFragment());
        readFragments.add(new LearningFragment());
        readFragments.add(new LiteratureFragment());

        readFragmentViewPageAdapter=new ReadFragmentViewPageAdapter(fragmentManager,readFragments);
        readFragmentViewPager.setAdapter(readFragmentViewPageAdapter);
        //缓存fragment的页数，默认是1；
        readFragmentViewPager.setOffscreenPageLimit(4); //原始TITLENUM-1
//        readFragmentViewPager.setFocusableInTouchMode(false);
//        readFragmentViewPager.setFocusable(false);
//        readFragmentViewPager.setPagingEnabled(false);
    }

    private void findViews() {
        //根节点
        mRoot=findViewById(R.id.ll_root);
        //标题
        mTvTitle=(TextView)mRoot.findViewById(R.id.tv_title);
        //搜索
        mIvSearch = (ImageView) mRoot.findViewById(R.id.iv_search);
        //换肤
        mIvChangeSkin = (ImageView) mRoot.findViewById(R.id.iv_changeskin);
        //模块列表头
        mListTitle = (LinearLayout) mRoot.findViewById(R.id.list_title);
        //情感
        raChildTitleArray[0] = (TextView) mRoot.findViewById(R.id.ra_emotion);
        //社会
        raChildTitleArray[1] =(TextView)mRoot.findViewById(R.id.ra_social);
        //百科
        raChildTitleArray[2] =(TextView)mRoot.findViewById(R.id.ra_encyclopedia);
        //学习
        raChildTitleArray[3] =(TextView)mRoot.findViewById(R.id.ra_learning);
        //文学
        raChildTitleArray[4] =(TextView)mRoot.findViewById(R.id.ra_literature);
        //滑块的滑道
        mCursorTrack = (LinearLayout) mRoot.findViewById(R.id.cursor_track);
        //高亮滑块
        mImageView = (ImageView) mRoot.findViewById(R.id.cursorlight);
        //fragment包涵体【自定义的ViewPager】
        readFragmentViewPager=(ReadFragmentViewPager)mRoot.findViewById(R.id.pagecontent_ll);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_changeskin:changeTheme();break;
                default:break;
        }
    }

    /**
     * 改变主题themeCenter.getColor(0):mThemes.get(mCurrentTheme).getColor(index);得到array.xml中array.xml数组的第0个，mCurrentTheme对应白天或者晚上
     */
    private void changeTheme() {
        //[1]获得当前主题
        mTheme=themeCenter.getTheme();
        //[2]判断当前主题，并设置将要变成的主题的值
        mTheme=mTheme==DAY_THEME?NIGHT_THEME:DAY_THEME;
        themeCenter.setTheme(mTheme);
        //[3]改变页面主题颜色
            //(1)改变5个TextView的背景
//        for (TextView textview:raChildTitleArray){
//            textview.setTextColor(themeCenter.getColor(ThemeCenter.CLR_FRAGMENT_TITLE_UNSELECTED));//getResources().getColor(R.color.day_fragment_title_unselected));
//        }
        //(2)改变当前被选中的fragment的页面的字体颜色
//        raChildTitleArray[currentIdex].setTextColor(themeCenter.getColor(ThemeCenter.CLR_FRAGMENT_TITLE_SELECTED));
        //(3)设置整个标题头的背景色
        mListTitle.setBackgroundColor(themeCenter.getColor(0));//getResources().getColor(R.color.day_fragment_title_background));
        //（4）设置滑道的背景
//        mCursorTrack.setBackgroundColor(themeCenter.getColor(ThemeCenter.CLR_CURSOR_TRACK));
//        mImageView.setBackgroundColor(themeCenter.getColor(ThemeCenter.CLR_CURSOR));
        //设置整个页面的背景色
//        mRoot.setBackgroundColor(themeCenter.getColor(ThemeCenter.CLR_BASIC_BACKGROUND));
        mRoot.setBackgroundColor(themeCenter.getColor(1));
        //[4]改变当前按钮的图标
        if (mTheme==DAY_THEME){
            mIvChangeSkin.setImageResource(R.drawable.btn_night);
        }else{
            mIvChangeSkin.setImageResource(R.drawable.btn_day);
        }
    }
}
