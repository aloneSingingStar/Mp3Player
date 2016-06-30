package com.founder.mp3player.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.founder.mp3player.R;

import org.apache.cordova.CordovaActivity;

import java.io.InputStream;

/**
 * HTML5页面
 */
public class Html5Activity extends CordovaActivity {
private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);
        webView=(WebView)findViewById(R.id.webview);
//       getActivity().getResources().openRawResourceFd(R.raw.index).getFileDescriptor().
//      InputStream is= getActivity().getResources().openRawResource(R.raw.index);
//        webView.loadData(is);
//               String url="android.resource://"+getActivity().getPackageName()+"/"+R.raw.index;
//               String url="file:///android_asset/raw/"+R.raw.index;
        webView.loadUrl("file:///android_asset/index.html");
//        webView.loadUrl("file:///raw/index.html");
//        webView.loadUrl(url);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
