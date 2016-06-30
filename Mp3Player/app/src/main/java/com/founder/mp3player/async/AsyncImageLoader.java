package com.founder.mp3player.async;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

import com.founder.mp3player.callback.CallbackImpl;
import com.founder.mp3player.utils.MD5Encrypt;

import java.io.File;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现图片异步加载
 * Created by Administrator on 2015/7/21.
 */
public class AsyncImageLoader {
    //键是图片的url，值是一个SoftReference对象，该对象指向一个Drawable对象
    private Map<String,SoftReference<Drawable>> imagecache=new HashMap<String,SoftReference<Drawable>>();
    private SoftReference<Drawable> drawSoftReference=null;
    private Drawable imageDrawable=null;
    /**
     * 下载图片
     * @param imageUrl
     * @param callback
     * @return
     */
    public Drawable loadDrawable(final String imageUrl, final CallbackImpl callback){
        //判断缓存中是否存在,存在则从缓存中取出
        if(imagecache.containsKey(imageUrl)){
            drawSoftReference=imagecache.get(imageUrl);
            imageDrawable=drawSoftReference.get();
            if (imageDrawable!=null){
                return imageDrawable;
            }
        }
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
               Drawable draw=(Drawable) msg.obj;
                callback.imageLoaded(draw);
            }
        };
        //如果缓存中不存在的话，就开启线程下载
        new Thread(){
            @Override
            public void run() {
                super.run();
                //根据Url下载图片
               imageDrawable=loadImageFromUrl(imageUrl);
                //将下载的图片放入缓存
                imagecache.put(imageUrl,new SoftReference<Drawable>(imageDrawable));
                //下载完成后通知主线程更新UI
                Message message=handler.obtainMessage(0,imageDrawable);
                handler.sendMessage(message);
            }
        }.start();
        //下载完成后使用Handler发送消息给主线程，然后在主线程中的ImageView中显示图片
        return null;
    }

    /**
     * 根据Url下载图片
     * @param imageUrl
     * @return
     */
    private Drawable loadImageFromUrl(String imageUrl) {
        Drawable drawable=null;
        try{
            drawable= Drawable.createFromStream(new URL(imageUrl).openStream(),"src");
        }catch (Exception e){
            e.printStackTrace();
        }

        return drawable;
    }

    /**
     * 回调接口，用于在图片下载完成后将图片设置到UI主线程的ImageView中
     */
    public interface ImageCallback{
        public void imageLoaded(Drawable imageDrawable);
    }
}
