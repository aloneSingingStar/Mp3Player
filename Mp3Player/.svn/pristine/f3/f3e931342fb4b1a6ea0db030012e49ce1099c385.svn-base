package com.founder.mp3player.callback;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.founder.mp3player.async.AsyncImageLoader;

/**
 * 实现了回调接口，在图片下载完成后，调用imageLoaded方法将图片设置到主线程的UI ImageView中
 * Created by Administrator on 2015/7/21.
 */
public class CallbackImpl implements AsyncImageLoader.ImageCallback {
    private ImageView imageView;
    public CallbackImpl(ImageView imageView) {
        this.imageView=imageView;
    }

    @Override
    public void imageLoaded(Drawable imageDrawable) {
        imageView.setImageDrawable(imageDrawable);
    }
}
