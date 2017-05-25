package com.tikeyc.tikeycandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.myApplication.MyApplication;

public class TLoginActivity extends TBaseActivity {



    private EditText username_et;
    private EditText password_et;
    private TextView loginButton_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlogin);

        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);

        loginButton_tv = (TextView) findViewById(R.id.loginButton_tv);
        loginButton_tv.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, TMainFragmentTabActivity.class);
        startActivity(intent);
        finish();
    }
}
