package com.founder.mp3player.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.founder.mp3player.model.Emotion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2015/7/20.
 */
public class EmotionInfoDao {
    private static EmotionInfoDao emotionInfoDao;
    private Context context;
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase mDb;
    public EmotionInfoDao(Context context){
        this.context=context;
        this.dbOpenHelper=new DBOpenHelper(context);
    }
    //单例模式获得实例
    public static EmotionInfoDao getInstance(Context context){
        if (emotionInfoDao==null){
            synchronized (EmotionInfoDao.class){
                if(emotionInfoDao==null){
                    emotionInfoDao=new EmotionInfoDao(context);
                }
            }
        }
        return emotionInfoDao;
    }

    /**\
     * 查询所有数据
     * @return
     */
    public List<Emotion> query(){
        List<Emotion> emotionList=new ArrayList<Emotion>();
        Emotion emotion=null;
        String sql="select * from weibo";
        synchronized (Object.class){
            mDb=dbOpenHelper.getWritableDatabase();
            mDb.beginTransaction();
            Cursor cursor=null;
            try {
                cursor=mDb.rawQuery(sql,null);
//            cursor=mDb.rawQuery(sql,params);
                cursor.moveToFirst();
                do{
                    emotion=new Emotion();
                    emotion.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    emotion.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                    emotion.setContent(cursor.getString(cursor.getColumnIndex("content")));
                    emotion.setImgUrl(cursor.getString(cursor.getColumnIndex("imageurl")));
                    emotionList.add(emotion);
                }while (cursor.moveToNext());
                mDb.setTransactionSuccessful();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                mDb.endTransaction();
                if (cursor!=null){
                    cursor.close();
                }
                //关掉后，再次查询会报错：java.lang.IllegalStateException: attempt to re-open an already-closed object: SQLiteDatabase: /data/data/com.founder.mp3player/files/weibo.db
               // mDb.close();
            }
        }
        return emotionList;
    }

    /**
     * 分页查询数据
     * @param limit
     * @param offset
     * @return
     */
    public List<Emotion> query(int limit,int offset){
        List<Emotion> emotionList=new ArrayList<Emotion>();
        Emotion emotion=null;
        Cursor cursor=null;
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT * FROM weibo WHERE 1=1 ");
        sql.append("LIMIT "+limit+" OFFSET "+offset);
       synchronized (Object.class){
           mDb=dbOpenHelper.getReadableDatabase();
           mDb.beginTransaction();
           try{
               cursor= mDb.rawQuery(sql.toString(),null);
               cursor.moveToFirst();
               do {
                   emotion=new Emotion();
                   emotion.setId(cursor.getInt(cursor.getColumnIndex("id")));
                   emotion.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                   emotion.setContent(cursor.getString(cursor.getColumnIndex("content")));
                   emotion.setImgUrl(cursor.getString(cursor.getColumnIndex("imageurl")));
                   emotionList.add(emotion);
               }while (cursor.moveToNext());
               mDb.setTransactionSuccessful();
           }catch (Exception e){
               e.printStackTrace();
           }finally {
               mDb.endTransaction();
               if (cursor!=null){
                   cursor.close();
               }
           }
       }
        return emotionList;
    }
    public void insert(Emotion emotion){
        synchronized (Object.class){
            mDb=dbOpenHelper.getWritableDatabase();
            mDb.execSQL("replace into weibo(id,author,content,imageurl) values(?,?,?,?)",new Object[]{emotion.getId(),emotion.getAuthor(),emotion.getContent(),emotion.getImgUrl()});
        }
    }
}
