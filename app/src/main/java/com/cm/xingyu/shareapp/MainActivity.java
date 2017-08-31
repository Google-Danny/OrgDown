package com.cm.xingyu.shareapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    Button signInButton;
    TextView loginTV;
    FrameLayout signInFL;
    FrameLayout signInBottomFL;
    FrameLayout loginFL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void initView() {
        signInButton = (Button) findViewById(R.id.sign_in);
        loginTV = (TextView) findViewById(R.id.login);
        signInFL = (FrameLayout) findViewById(R.id.sign_in_FL);
        signInBottomFL = (FrameLayout) findViewById(R.id.sign_in_bottom_FL);
        loginFL = (FrameLayout) findViewById(R.id.loginFL);
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
        loginFL.setVisibility(View.VISIBLE);
    }

    //注册方法
    private void signInMethod() {
        signInFL.setVisibility(View.VISIBLE);
        signInBottomFL.setVisibility(View.VISIBLE);

    }


}
