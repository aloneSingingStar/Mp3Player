package com.founder.mp3player.download;

import com.founder.mp3player.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2015/7/5.
 */
public class HttpDownloader {
    private URL url;
    private HttpURLConnection urlcon;
    private BufferedReader bReader;
    private StringBuffer strBuffer;
    private  String br=null;

    /**
     * 根据URL下载文件，前提是这个文件当中的内容是文本，函数的返回值就是文件当中的内容
     * @param urlstr
     * @return
     */
    public String download(String urlstr){
        try {
            strBuffer=new StringBuffer();
            url=new URL(urlstr);
             urlcon =(HttpURLConnection)url.openConnection();
            urlcon.setDoInput(true);
            urlcon.setDoOutput(true);
            //【mp3的文件名如果不规范，得到的is会为null】
            InputStream is = urlcon.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            bReader=new BufferedReader(reader);
            while ((br=bReader.readLine())!=null){
                strBuffer.append(br);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (bReader!=null){
                    bReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  strBuffer.toString();
    }

    /**
     * 该函数返回整形 -1：代表下载文件出错 0：代表下载文件成功 1：代表文件已经存在
     */
    public int downFile(String urlstr,String path,String fileName){
        InputStream inputStream=null;
        try{
            FileUtils fileUtils=new FileUtils();
            if (fileUtils.isFileExist(fileName,path)){
                return 1;
            }else{
                inputStream=getInputStreamFromUrl(urlstr);
                //mp3文件名不规范时，得到的inputStream为null,这种情况，直接返回-1，表示下载失败
                if(inputStream==null){
                    return -1;
                }else {
                    File resultFile=fileUtils.write2SDFromInput(path,fileName,inputStream);
                    if (resultFile==null){
                        return -1;
                    }
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return 0;
    }

    /**根据URL得到输入流
     *
     * @param urlstr
     * @return
     */
    private InputStream getInputStreamFromUrl(String urlstr){
        InputStream inputStream=null;
        try {
            url=new URL(urlstr);
            urlcon =(HttpURLConnection)url.openConnection();
            /*urlcon.setDoInput(true);
            urlcon.setDoOutput(true);*/
            inputStream = urlcon.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        InputStream inputStream=null;
//        try{
//            url=new URL(urlstr);
//            HttpURLConnection urlCon=(HttpURLConnection)url.openConnection();
//             inputStream=urlCon.getInputStream();
//        }catch (MalformedURLException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return inputStream;
    }
}
