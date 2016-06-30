package com.founder.mp3player.xmlsax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/5.
 */
public class Mp3ListContentHandler extends DefaultHandler {
    //保存当前处理的节点的名字
    private String preTag;
    //用于保存当前处理节点的数据
    private HashMap<String,String> curMap;
    //用于保存最终的结果
    private ArrayList<HashMap<String,String>> result;

    public Mp3ListContentHandler(ArrayList<HashMap<String, String>> result) {
        this.result = result;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        result=new ArrayList<Map<String,String>>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //每个resource表示一个项
        if ("resource".equals(localName)){
            curMap=new HashMap<String,String>();
        }
        //用于保存当前处理的节点名称,用于后面判断用
        preTag=localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String data=new String(ch,start,length);
        if ("id".equals(preTag)){
            curMap.put("id",data);
        }else if ("mp3.name".equals(preTag)){
            curMap.put("mp3_name",data);
        }else if ("mp3.size".equals(preTag)){
            curMap.put("mp3_size",data);
        }else if ("lrc.name".equals(preTag)){
            curMap.put("lrc_name",data);
        }else if ("lrc.size".equals(preTag)){
            curMap.put("lrc_size",data);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //表示一条数据处理完毕
        if ("resource".equals(localName)){
            result.add(curMap);
            curMap=null;
        }
        preTag=null;
    }
}
