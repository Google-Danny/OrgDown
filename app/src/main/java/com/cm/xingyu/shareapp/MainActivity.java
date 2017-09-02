package com.cm.xingyu.shareapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cm.xiaoyu.database.DBHelper;
import com.cm.xiaoyu.database.DBManager;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button signInButton;
    private TextView loginTV;
    private FrameLayout signInFL;
    private FrameLayout signInBottomFL;
    private FrameLayout loginFL;
    private TextView slideText;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        signInButton = (Button) findViewById(R.id.sign_in_main);
        loginTV = (TextView) findViewById(R.id.login);
        slideText = (TextView) findViewById(R.id.slide_text);
    }

    @Override
    public void initData() {


    }

    @Override
    public void initListener() {
        signInButton.setOnClickListener(this);
        loginTV.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in:
                signInMethod();
                break;
            case R.id.login:
                loginMethod();

        }
    }

    //登录方法
    private void loginMethod() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.test2, R.anim.test1);
    }

    //注册方法
    private void signInMethod() {
        dbHelper = DBManager.getInstance(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Intent intent = new Intent();
        intent.setClass(this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.test2, R.anim.test1);
    }


}
