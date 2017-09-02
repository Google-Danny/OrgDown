package com.cm.xiaoyu.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/2.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //当数据库打开时回调的函数
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i("tag", "-----------onOpen---------");
    }

    //数据库创建时回调的函数
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag", "-----------onCreate---------");
        String sql = "create table "+Constant.TABLE_NAME+"("+Constant._ID+" Integer primary key,"+ Constant.FIRST_NAME+" varchr[10]," +
                ""+Constant.SECOND_NAME+" varchar[10],"+Constant.EMAIL+" varchar[10],"+Constant.PASSWORD+" varchar[10] ) ";
        db.execSQL(sql);
    }

    //数据库更新时回调的函数
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("tag", "-----------onUpgrade---------");
    }
}
