package com.cm.xingyu.shareapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cm.xiaoyu.database.Constant;
import com.cm.xiaoyu.database.DBHelper;
import com.cm.xiaoyu.database.DBManager;

import java.util.Timer;
import java.util.TimerTask;

public class SignInActivity extends BaseActivity implements View.OnClickListener {
    private EditText firstName;
    private InputMethodManager imm;
    private ScrollView scrollView;
    private Button cancel;
    private Button signIn;
    private EditText secondName;
    private EditText email;
    private EditText password;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        firstName = (EditText) findViewById(R.id.first_name);
//        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        cancel = (Button) findViewById(R.id.sign_in_cancel);
        signIn = (Button) findViewById(R.id.sign_in);
        secondName = (EditText) findViewById(R.id.second_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    @Override
    public void initData() {
        popupKeyboard();
    }

    @Override
    public void initListener() {
        cancel.setOnClickListener(this);
        signIn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_cancel:
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.sign_in:
                signInMethod();
                break;

            default:
                break;


        }


    }

    private void signInMethod() {
        dbHelper = DBManager.getInstance(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "insert into "+ Constant.TABLE_NAME+" values(1,'小宇','高','489280926@qq.com','123456')";
        DBManager.execSql(database,sql);
        database.close();
    }

    //当进入注册页面自动弹出键盘
    private void popupKeyboard() {
        imm = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) firstName.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                               imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);

                           }

                       },
                998);
        firstName.setHint("名字");
    }


}
