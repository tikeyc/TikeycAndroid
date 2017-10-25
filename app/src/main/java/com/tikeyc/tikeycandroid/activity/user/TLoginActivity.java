package com.tikeyc.tikeycandroid.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.activity.main.IndexMainActivity;
import com.tikeyc.tikeycandroid.activity.main1.TMainFragmentTabActivity;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.myApplication.MyApplication;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

public class TLoginActivity extends TBaseActivity {



    private EditText username_et;
    private EditText password_et;
    private Button loginButton_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlogin);

        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);

        loginButton_bt = (Button) findViewById(R.id.loginButton_tv);
        loginButton_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        String userid = "tikeyc";
        username_et.setText(userid);
        String password = "123456";
        password_et.setText(password);
    }


    /**
     *
     */
    private void login() {
        //开始登录
        final String userid = username_et.getText().toString();
        String password = password_et.getText().toString();

        MyApplication myApplication = (MyApplication) getApplication();
        Intent intent = new Intent(this, IndexMainActivity.class);
        startActivity(intent);
        BGASwipeBackHelper.executeForwardAnim(this);
        finish();
    }
}
