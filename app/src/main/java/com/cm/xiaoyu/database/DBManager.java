package com.cm.xiaoyu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 主要是对数据库操作的工具类
 */
public class DBManager {
    private static DBHelper helper;

    public static DBHelper getInstance(Context context) {
        if (helper == null) {
            helper = new DBHelper(context);
        }
        return helper;
    }

    public static void execSql(SQLiteDatabase db, String sql) {
        if (db != null) {
            if (sql != null && !"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }
}

