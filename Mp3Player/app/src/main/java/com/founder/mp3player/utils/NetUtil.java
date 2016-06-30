package com.founder.mp3player.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * 网络工具类
 * <p>
 * <p/>
 * </p>
 *
 * @author：张鹏
 * @corporation: 汇添富
 * @version:1
 * @date:2014-11-14
 */
public class NetUtil {
    private static boolean DEBUGE = false;
    private static long lastTime = 0;
    private static Toast toast;

    /**
     * x检查网络是否可以连接互联网
     *
     * @param context
     * @return x是返回true，否则返回false
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {//获取所有网络连接信息
            NetworkInfo[] info = null;
            try {
                info = connectivity.getAllNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (StackOverflowError e) {
                e.printStackTrace();
            }
            if (info != null) {//逐一查找状态为已连接的网络
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检查网络是否连接是否可以连接服务器，不可用会显示不能连接的提示，并关闭等待框
     *
     * @param context
     * @return x可以连接返回true，否则返回false
     */
    public static boolean checkNetworkAvailable(Context context) {
        if (isNetworkAvailable(context)) {
            return true;
        } else {
//            toast = Toast.makeText(context, "网络连接不可用，请检查您的网络是否正常！", Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();
        }
        return false;
    }

    /**
     * 对网络连接状态进行判断
     *
     * @return true, 可用； false， 不可用
     */
    public boolean isOpenNetwork(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    public static void showNetErrToast(Context context) {
        if (DEBUGE && context != null) {
            Toast.makeText(context, "请检查您的网络连接", Toast.LENGTH_SHORT).show();
        }
    }
    public static void showNetErrToast(Context context, int errInfo) {
        if (DEBUGE && context != null) {
            Toast.makeText(context, "请检查您的网络连接"+"，错误参数：" + Integer.toHexString(errInfo), Toast.LENGTH_SHORT).show();
        }
    }

    public static void showNetErrToast(Context context, long time) {
        if (time - lastTime > 300*1000) { //超过一分钟显示一次
            lastTime = time;
            Toast.makeText(context, "请检查您的网络连接", Toast.LENGTH_SHORT).show();
        }
    }
}
