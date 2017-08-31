package com.cm.xingyu.shareapp;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }

    public abstract  void initView();

    public abstract  void initData();

    public abstract  void  initListener();
}
