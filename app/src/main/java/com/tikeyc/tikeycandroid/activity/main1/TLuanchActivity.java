package com.tikeyc.tikeycandroid.activity.main1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.activity.user.TLoginActivity;
import com.tikeyc.tikeycandroid.base.TBaseActivity;

public class TLuanchActivity extends TBaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Intent intent = new Intent(TLuanchActivity.this,TLoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tluanch);


        handler.sendEmptyMessageDelayed(0,1);
    }
}
