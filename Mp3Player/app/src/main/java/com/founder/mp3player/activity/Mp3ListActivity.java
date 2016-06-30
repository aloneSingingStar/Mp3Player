package com.founder.mp3player.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.founder.mp3player.R;
import com.founder.mp3player.download.HttpDownloader;
import com.founder.mp3player.model.Mp3Info;
import com.founder.mp3player.service.DownloadService;
import com.founder.mp3player.xmlsax.Mp3ListContentHandler;
import com.founder.mp3player.xmlsax.Mp3ListContentHandler2;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 实现列表功能ListActivity,其布局文件中必须有个listView
 */
public class Mp3ListActivity extends ListActivity {
    private boolean threadDisable=false;
    private  int count=0;
    private List<Mp3Info> mp3Infos=null;
    //下载得到的xml
    private String strxml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_list);
        updateListView();
    }

    /**
     * 在用户点击menu按钮后会调用该方法，我们可以往里面添加自己的按钮控件
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menu.add(0,UPDATE,1,R.string.menu_update_list);
        //获取layout文件中的menu的xml文件
        getMenuInflater().inflate(R.menu.menu_mp3_list, menu);
        return true;
    }

    /**
     * 菜单选择后的动作
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.menu_update_list){
          updateListView();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 点击ListView里面的选项后下载该文件
     * @param l
     * @param v
     * @param position【第一行为0，第二行为1。。。。相当于索引】
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //获得点击的文件名
        Mp3Info mp3Info=mp3Infos.get(position);
        Intent intent=new Intent();
        //mp3Info实现序列号接口
        intent.putExtra("mp3Info",mp3Info);
        intent.setClass(this, DownloadService.class);
        //启动下载服务
        startService(intent);
        super.onListItemClick(l, v, position, id);
    }

    Handler myhandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //下载完成后，解析xml并且适配列表到ListView
            switch (msg.what){
                case 9999:saxAndshow();
                    break;
            }

        }
    };

    /**
     * 解析并将音乐播放列表适配到ListView
     */
    private void saxAndshow() {
                       mp3Infos=Parse2(strxml);
                    List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
                    for (Iterator iterator=mp3Infos.iterator();iterator.hasNext();){
                        Mp3Info mp3Info=(Mp3Info)iterator.next();
                        HashMap<String,String> map=new  HashMap<String,String>();
                        map.put("mp3_name",mp3Info.getMp3Name());
                        map.put("mp3_size",mp3Info.getMp3Size());
                        list.add(map);
                    }
                    SimpleAdapter simpleAdater=buildSimpleAdapter2(list);
                    setListAdapter(simpleAdater);
    }


    /**
     * 更新播放列表【注意：在子线程中下载xml，要下载完成后再执行解析和适配的工作，如果没有下载完就返回strxml,则strxml为空，主线程报错，那么子线程也无法继续执行】
     */
    public void updateListView(){
        //从Apache服务器下载存储音乐播放列表的xml
        //xml = downloadXML("http://localhost:8080/mp3/resources.xml");
        //xml = downloadXML("http://127.0.0.1:8080/mp3/resources.xml");
//        xml = downloadXML("http://192.168.134.131:8080/mp3/resources.xml");
        downloadXML("http://192.168.135.92:8080/mp3/resources.xml");
    }

    /**
     * 开启线程下载xml
     * @param url
     */
    private void downloadXML(String url) {
        HttpDownloader downloader = new HttpDownloader();
       DownloadxmlThread downloadxmlThread=new DownloadxmlThread(downloader,url);
       Thread thread=new Thread(downloadxmlThread);
        thread.start();
    }

    private SimpleAdapter buildSimpleAdapter2(List<HashMap<String, String>> list) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.mp3info_item, new String[]{"mp3_name", "mp3_size"}, new int[]{R.id.mp3_name, R.id.mp3_size});
        return simpleAdapter;
    }

    private List<Mp3Info> Parse2(String xml) {
        Log.i("xmlValue", xml);
        List<Mp3Info> infos=new ArrayList<Mp3Info>();
        SAXParserFactory saxfactory=SAXParserFactory.newInstance();
        try {
            SAXParser sax=saxfactory.newSAXParser();
            XMLReader xmlReader=sax.getXMLReader();
            Mp3ListContentHandler2 mp3listHandler=new Mp3ListContentHandler2(infos);
            xmlReader.setContentHandler(mp3listHandler);
            xmlReader.parse(new InputSource(new StringReader(xml)));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infos;
    }

    class DownloadxmlThread implements Runnable {
        private  HttpDownloader downloader;
        private String url;
        DownloadxmlThread(HttpDownloader downloader,String url) {
            this.downloader = downloader;
            this.url=url;
        }

        @Override
        public void run() {
            Message message = new Message();
                 strxml = downloader.download(url);
                count++;
                message.arg1 = count;
                message.what = 9999;
                myhandle.sendMessage(message);
        }

        /**
         * 使用SimpleAdapter将音乐播放列表适配到ListView
         * 在ListView中要显示信息的话，还需要一个布局文件
         * SimpleAdapter参数说明
         * * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
         * 第二个参数表示生成一个Map(String ,Object)列表选项
         * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
         * 第四个参数表示该Map对象的哪些key对应value来生成列表项
         * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
         * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
         *
         * @param
         * @return
         */
//        private SimpleAdapter buildSimpleAdapter(ArrayList<HashMap<String, String>> mp3list) {
//            List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//            for (Map<String, String> m : mp3list) {
//                for (String key : m.keySet()) {
//                    HashMap<String, String> map = new HashMap<String, String>();
//                    if ("mp3_name".equals(key)) {
//                        map.put("mp3_name", m.get(key));
//                    }
//                    if ("mp3_size".equals(key)) {
//                        map.put("mp3_size", m.get(key));
//                    }
//                    if (map != null) {
//                        list.add(map);
//                    }
//
//                    System.out.println(key + " : " + m.get(key));
//                }
//            }
//            SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.mp3info_item, new String[]{"mp3_name", "mp3_size"}, new int[]{R.id.mp3_name, R.id.mp3_size});
//            return simpleAdapter;
//        }


        private ArrayList<HashMap<String, String>> Parse(String xml) {
            ArrayList<HashMap<String, String>> mp3list = new ArrayList<HashMap<String, String>>();
            SAXParserFactory saxfactory = SAXParserFactory.newInstance();
            try {
                SAXParser sax = saxfactory.newSAXParser();
                XMLReader xmlReader = sax.getXMLReader();
                Mp3ListContentHandler mp3listHandler = new Mp3ListContentHandler(mp3list);
                xmlReader.setContentHandler(mp3listHandler);
                xmlReader.parse(new InputSource(new StringReader(xml)));

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mp3list;
        }

    }
}
