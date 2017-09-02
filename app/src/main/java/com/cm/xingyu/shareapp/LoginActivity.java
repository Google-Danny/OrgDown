package com.cm.xingyu.shareapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cm.xiaoyu.database.Constant;
import com.cm.xiaoyu.database.DBHelper;
import com.cm.xiaoyu.database.DBManager;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private DBHelper dbHelper;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        login = (Button) findViewById(R.id.login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
       login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.login:
                 dbHelper = DBManager.getInstance(this);
                 SQLiteDatabase database = dbHelper.getWritableDatabase();
                 Cursor cursor = database.rawQuery("select * from "+ Constant.TABLE_NAME+"",null);
                  while (cursor.moveToNext()){
                      String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
                      Log.e("tag",firstName);
                  }
                 database.close();
                 break;

         }
    }
}
