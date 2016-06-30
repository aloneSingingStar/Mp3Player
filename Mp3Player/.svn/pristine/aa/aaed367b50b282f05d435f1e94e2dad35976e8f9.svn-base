package com.founder.mp3player.xmlsax;

import com.founder.mp3player.model.Mp3Info;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/7/5.
 */
public class Mp3ListContentHandler2 extends DefaultHandler {
    private List<Mp3Info> infos=null;
    private Mp3Info mp3Info=null;
    //保存当前处理的节点的名字
    private String preTag;
    //用于保存当前处理节点的数据


    public Mp3ListContentHandler2(List<Mp3Info> infos) {
        this.infos = infos;
    }

    public Mp3Info getMp3Info() {
        return mp3Info;
    }

    public void setMp3Info(Mp3Info mp3Info) {
        this.mp3Info = mp3Info;
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
        this.preTag=localName;
        if (preTag.equals("resource")){
            mp3Info=new Mp3Info();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String data=new String(ch,start,length);
        if ("id".equals(preTag)){
            mp3Info.setId(data);
        }else if ("mp3.name".equals(preTag)){
            mp3Info.setMp3Name(data);
        }else if ("mp3.size".equals(preTag)){
            mp3Info.setMp3Size(data);
        }else if ("lrc.name".equals(preTag)){
           mp3Info.setLrcName(data);
        }else if ("lrc.size".equals(preTag)){
            mp3Info.setLrcSize(data);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("resource")){
            infos.add(mp3Info);
        }
        preTag=null;
    }
}
