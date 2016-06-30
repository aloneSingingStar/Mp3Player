package com.founder.mp3player.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;


import com.founder.mp3player.R;

import java.util.ArrayList;

/**
 * Created by 1234 on 2015/4/7.
 */
public class ThemeCenter {

    public static final int DAY_COLOR_THEME = 0;
    public static final int NIGHT_COLOR_THEME = 1;

    //颜色常量名
    public static final int CLR_FRAGMENT_TITLE_SELECTED = 0;//碎片头选中字体颜色
    public static final int CLR_FRAGMENT_TITLE_UNSELECTED = 1;
    public static final int CLR_FRAGMENT_TITLE_BACKGROUND = 2;
    public static final int CLR_CURSOR_TRACK = 3;
    public static final int CLR_LIST_TITLE = 4;
    public static final int CLR_LIST_TITLE_BACKGROUND = 5;
    public static final int CLR_LINE_BETWEEN_TITLE_AND_ITEM = 6;
    public static final int CLR_LINE_BETWEEN_ITEMS = 7;
    public static final int CLR_STOCK_NAME_IN_ITEM = 8;
    public static final int CLR_STOCK_CODE_IN_ITEM = 9;
    public static final int CLR_PRICE_UP_IN_ITEM = 10;
    public static final int CLR_PRICE_DOWN_IN_ITEM = 11;
    public static final int CLR_LIST_ITEM_BACKGROUND = 12;
    public static final int CLR_PRICE_DOWN_BACKGROUD_IN_ITEM = 13;
    public static final int CLR_PRICE_UP_BACKGROUD_IN_ITEM = 14;
    public static final int CLR_PRICE_DID_NOT_CHANGE_BACKGROUND = 15;
    public static final int CLR_PRICE_DID_NOT_CHANGE = 16;
    public static final int CLR_LISTVIEW_BACKGROUND = 17;
    public static final int CLR_THIRD_COLUMN_TEXT = 18;
    public static final int CLR_REFRESH_TEXT = 19;
    public static final int CLR_REFRESH_BACKGROUD = 20;
    public static final int CLR_CHART_TITLE_SELECTED = 21;
    public static final int CLR_CHART_TITLE_UNSELECTED = 22;
    public static final int CLR_CHART_TITLE_BACKGROUND_SELECTED = 23;
    public static final int CLR_CHART_TITLE_BACKGROUND_UNSELECTED = 24;
    public static final int CLR_INFO_TITLE_SELECTED = 25;
    public static final int CLR_INFO_TITLE_UNSELECTED = 26;
    public static final int CLR_PANKOU_TITLE = 27;
    public static final int CLR_F10_ITEM_TEXT = 28;
    public static final int CLR_F10_ITEM_BACKGROUND = 29;
    public static final int CLR_HUSHEN_BACKGROUND = 30;
    public static final int CLR_HUSHEN_LIST_TITLE_TEXT = 31;
    public static final int CLR_HUSHEN_LIST_TITLE_BACKGROUND = 32;
    public static final int CLR_HUSHEN_LIST_TITLE_BORDERLINE = 33;
    public static final int CLR_BASIC_BACKGROUND = 34;
    public static final int CLR_LINES_STOCK_PANKOU = 35;
    public static final int CLR_CURSOR = 36;
    public static final int CLR_STCOK_FENSHI_lINE = 37;
    public static final int CLR_STCOK_FENSHI_FILL = 38;
    public static final int CLR_STCOK_FENSHI_AVERAGELINE = 39;
    public static final int CLR_BUY_SELL_DELETE_TEXT = 40;
    public static final int CLR_LINE_ABOVE_BUY_SELL_BTN = 41;
    public static final int CLR_BIGSTOCK_HEAD_BACKGROUND = 42;
    public static final int CLR_BIGSTOCK_HEAD_TEXT = 43;
    public static final int CLR_NDO_CONTRACT_ITEM_TEXT = 44;
    public static final int CLR_NDO_CONTRACT_ITEM_VALUE = 45;
    public static final int CLR_OPTIONAL_BOTTOM_BACKGROUND = 46;
    public static final int CLR_SEARCH_STOCK_BACKGROUND = 57;
    public static final int CLR_SEARCH_LINE = 58;
    public static final int CLR_SEARCH_TEXT = 59;
    public static final int CLR_SEARCH_CLEAR_HISTORY = 60;
    public static final int CLR_SEARCH_TEXT_LAYOUT = 61;
    public static final int CLR_BIGCHART_CROSSLINE = 62;
    public static final int CLR_BIGCHART_CROSSLINE_XYBG = 63;
    public static final int CLR_BIGCHART_CROSSLINE_XYVALUE = 64;
    public static final int CLR_STOCK_CHENGJIAO_LIANG=65;
    public static final int CLR_BOTTOM_TEXT_COLOR_SELECTED = 66;
    public static final int CLR_BOTTOM_TEXT_COLOR_UNSELECTED = 67;
    public static final int CLR_F10_FORM_TITLE = 68;
    public static final int CLR_F10_FORM_CONTENT = 69;
    public static final int CLR_F10_TWO_BLOCK_PROPERTY_CONTENT = 70;
    public static final int CLR_F10_TWO_BLOCK_END_UPDATE = 71;
    public static final int CLR_F10_DIVIDER = 72;

    //图标常量名
    public static final int IMG_LITTLE_TRIANGLE = 0;//排序按钮小黑三家
    public static final int IMG_LINE_2_UNDER_INFO_TITLE_SLECTED = 1;//股票详情第三个碎片表头下面线，选中状态
    public static final int IMG_LINE_2_UNDER_INFO_TITLE_UNSLECTED = 2;//股票详情第三个碎片表头下面线，未选中状态
    public static final int IMG_ARROW_UP = 3;
    public static final int IMG_ARROW_DOWN = 4;
    public static final int IMG_HUSHEN_GROUP_OPEN = 5;
    public static final int IMG_HUSHEN_GROUP_CLOSE = 6;
    public static final int IMG_NEW_STOCK_CHUANG = 7;
    public static final int IMG_HONGKONG_STOCK_HK = 8;
    public static final int IMG_BUY_SELL_BTN_BACKGROUND = 9;//按钮背景样式，常态和按下颜色不一样
    public static final int IMG_BUY_IN_BTN = 10;
    public static final int IMG_SELL_OUT_BTN = 11;
    public static final int IMG_DELETE_OPTIONAL_BTN = 12;
    public static final int IMG_STOCK_PLATE_IMV = 13;
    public static final int IMG_NOD_LISTTITLE_RIGHT = 14;
    public static final int IMG_F10_ITEM_BACKGROUND = 15;
    public static final int IMG_BTN_ADD_OPTION = 16;
    public static final int IMG_BTN_DELETE_OPTION = 17;
    public static final int IMG_SEARCH_CANCEL = 18;
    public static final int IMG_SEARCH_BOX_SEARCH = 19;
    public static final int IMG_SEARCH_EDITTEXT = 20;
    public static final int IMG_KEYBOARD_LAYOUT = 21;
    public static final int IMG_KEYBOARD_ENGLISH_LAYOUT = 22;
    public static final int IMG_LEFT_PRICE = 23;
    public static final int IMG_LIST_ITEM_BACKGROUND = 24;
    public static final int IMG_HUSHEN_GROUP_BACKGROUND = 25;
    public static final int IMG_SEARCH_SOTOCK_ZHISHU = 26;
    public static final int IMG_BOTTOM_HOME_PAGE = 27;
    public static final int IMG_BOTTOM_PRICE = 28;
    public static final int IMG_BOTTOM_TRADE = 29;
    public static final int IMG_BOTTOM_GOLD_INGOT = 30;
    public static final int IMG_BOTTOM_JLY = 31;
    public static final int IMG_BOTTOM_MORE = 32;
    public static final int IMG_BOTTOM_BACKGROUND = 33;
    public static final int IMG_F10_FORM_BACKGROUND = 34;
    /**二级页面中每一小块内容的背景*/
    public static final int IMG_F10_TWO_BLOCK_BACKGROUND = 35;
    /**二级页面中每一小块内容中上部条目的背景*/
    public static final int IMG_F10_TWO_BLOCK_TOP_BAR_BACKGROUND = 36;
    /**一级页面箭头*/
    public static final int  IMG_F10_FIRST_ARROW_UP_BACKGROUND=37;
    public static final int  IMG_F10_FIRST_ARROW_DOWN_BACKGROUND=38;

    public static final int BUTTON_COLOR_CHANGED = 0;//换肤按钮图标

    // K 线图相关
    public static final int CLR_KLINE_BORDER = 47;
    public static final int CLR_KLINE_LEGEND_TEXT = 48;
    public static final int CLR_KLINE_RULER_TEXT = 49;
    public static final int CLR_KLINE_RISE = 50;
    public static final int CLR_KLINE_FALL = 51;
    public static final int CLR_KLINE_NO_CHANGE = 52;
    public static final int CLR_KLINE_LEGEND_1 = 53;
    public static final int CLR_KLINE_LEGEND_2 = 54;
    public static final int CLR_KLINE_LEGEND_3 = 55;
    public static final int CLR_KLINE_LEGEND_4 = 56;

    private int mCurrentTheme = DAY_COLOR_THEME;

    private ArrayList<Theme> mThemes = new ArrayList<Theme>();

    private static ThemeCenter ourInstance;

    private Context mContext;

    public static ThemeCenter getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new ThemeCenter(context);
        }
        return ourInstance;
    }

    public static ThemeCenter getInstance() {
        return ourInstance;
    }

    private ThemeCenter(Context context) {
        mContext = context;
        mCurrentTheme = DAY_COLOR_THEME;
        initFromResources();
    }

    private void initFromResources() {
        mThemes.add(0, new Theme(R.array.day_color, R.array.day_icon));
        mThemes.add(1, new Theme(R.array.night_color, R.array.night_icon));
    }

    public int getColor(int index) {
        return mThemes.get(mCurrentTheme).getColor(index);
    }
    public Drawable getDrawable(int index){
        return mThemes.get(mCurrentTheme).getDrawable(index);
    }
    public int getResourceId(int index){
        return mThemes.get(mCurrentTheme).getResourceId(index);
    }

    public void setTheme(int theme){
        if (theme != ThemeCenter.DAY_COLOR_THEME
                && theme != ThemeCenter.NIGHT_COLOR_THEME) {
            throw new ThemeNotFoundException("Theme should be 1 or 0, your parameter was"+ theme);
        }
        mCurrentTheme = theme;
    }

    public int getTheme(){
        return mCurrentTheme;
    }
//    public void changeCurrentTheme(){
//        mCurrentTheme = mCurrentTheme == DAY_COLOR_THEME ?
//                NIGHT_COLOR_THEME : DAY_COLOR_THEME;
//    }

    private class Theme {
//        private ArrayList<Integer> mColors = new ArrayList<Integer>();//颜色的值，不是颜色id
//        private ArrayList<Drawable> mDrawables = new ArrayList<Drawable>();//图片的id

        private TypedArray mColors;
        private TypedArray mDrawables;

        public Theme(int rIdColor, int rIdDramable) {
            initFromResourceFile(rIdColor, rIdDramable);

        }

        private void initFromResourceFile(int rIdColor, int rIdDramable) {
            mColors = mContext.getResources().obtainTypedArray(rIdColor);
//            for (int i = 0; i < colors.length(); i++) {
//                mColors.add(colors.getColor(i,0));
//            }
            mDrawables = mContext.getResources().obtainTypedArray(rIdDramable);
//            for (int i = 0; i < drawables.length(); i++) {
//                mDrawables.add(drawables.getDrawable(i));
//            }
        }

        public int getColor(int index) {
            return mColors.getColor(index, 0x00000000);
        }
        public Drawable getDrawable(int index) {
            return mDrawables.getDrawable(index);
        }
        public int getResourceId(int index) {return mDrawables.getResourceId(index, 0);}

    }
    private static class ThemeNotFoundException extends RuntimeException {

        public ThemeNotFoundException(String message) {
            super(message);
        }
    }
}
