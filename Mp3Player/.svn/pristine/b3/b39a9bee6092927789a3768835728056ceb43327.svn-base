
package com.founder.mp3player.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static String getDateCN() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;// 2012年10月03日 23:41:31
    }

    public static String getDateEN() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = format1.format(new Date(System.currentTimeMillis()));
        return date1;// 2012-10-03 23:41:31
    }

    public static String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;
    }

    public static String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;
    }

    public static String getDateAndTime() {
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd HH:mm:ss");
        String date1 = format1.format(new Date(System.currentTimeMillis()));
        return date1;// 2012-10-03 23:41:31
    }
    
    public static String getDateJy() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(new Date(System.currentTimeMillis()));
        return date1;// 2012-10-03 23:41:31
    }
    
    public static String getDateJy(Date date) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(date);
        return date1;// 2012-10-03 
    }
}
