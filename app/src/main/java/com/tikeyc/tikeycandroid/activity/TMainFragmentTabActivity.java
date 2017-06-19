package com.tikeyc.tikeycandroid.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.fragment.tab.THomeFragment;
import com.tikeyc.tikeycandroid.fragment.tab.TNewsFragment;
import com.tikeyc.tikeycandroid.fragment.tab.TReleaseFragment;
import com.tikeyc.tikeycandroid.fragment.tab.TUserFragment;
import com.tikeyc.tikeycandroid.myApplication.MyApplication;

/**
 * Created by public1 on 2017/5/16.
 */

public class TMainFragmentTabActivity extends FragmentActivity {


    public static final String TAB_HOME = "home";
    public static final String TAB_MESSAGE = "message";
    public static final String TAB_RELEASE = "release";
    public static final String TAB_USER = "user";


    private TextView mHomeTab;
    private TextView mMessageTab;
    private TextView mAddTab;
    private TextView mUserTab;

    private Drawable mHomePressed;
    private Drawable mHomeNormal;
    private Drawable mMessagePressed;
    private Drawable mMessageNormal;
    private Drawable mAddPressed;
    private Drawable mAddNormal;
    private Drawable mUserPressed;
    private Drawable mUserNormal;


    private FrameLayout realtabcontent;
    private FragmentTabHost tabhost;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_main_fragment_tab);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        MyApplication myApplication = (MyApplication) getApplication();

        initViews();
    }


    private void initViews() {
        realtabcontent = (FrameLayout) findViewById(R.id.realtabcontent);
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);

        tabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        Bundle fragmentBundle = new Bundle();
        View indicator = getIndicatorView(TAB_HOME);
        TabHost.TabSpec tabSpec_home = tabhost.newTabSpec(TAB_HOME).setIndicator(indicator);
        tabhost.addTab(tabSpec_home, THomeFragment.class,fragmentBundle);

        indicator = getIndicatorView(TAB_MESSAGE);
        tabhost.addTab(tabhost.newTabSpec(TAB_MESSAGE).setIndicator(indicator), TNewsFragment.class, fragmentBundle);

        indicator = getIndicatorView(TAB_RELEASE);
        tabhost.addTab(tabhost.newTabSpec(TAB_RELEASE).setIndicator(indicator),TReleaseFragment.class, fragmentBundle);

        indicator = getIndicatorView(TAB_USER);
        tabhost.addTab(tabhost.newTabSpec(TAB_USER).setIndicator(indicator),TUserFragment.class, fragmentBundle);

        tabhost.setOnTabChangedListener(listener);
        listener.onTabChanged(TAB_HOME);
    }



    private View getIndicatorView(String tab) {
        View tabView = View.inflate(this, R.layout.main_tab_item, null);
        TextView indicator = (TextView) tabView.findViewById(R.id.tab_text);
        Drawable drawable;

        if (tab.equals(TAB_HOME)) {
            indicator.setText("主页");
            drawable = getResources().getDrawable(R.mipmap.tab_home_normal);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            indicator.setCompoundDrawables(null, drawable, null, null);
            mHomeTab = indicator;
        } else if (tab.equals(TAB_MESSAGE)) {
            indicator.setText("消息");
            drawable = getResources().getDrawable(R.mipmap.tab_message_normal);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            indicator.setCompoundDrawables(null, drawable, null, null);
            mMessageTab = indicator;
        } else if (tab.equals(TAB_RELEASE)) {
            indicator.setText("增加");
            drawable = getResources().getDrawable(R.mipmap.tab_add_normal);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            indicator.setCompoundDrawables(null, drawable, null, null);
            mAddTab = indicator;
        } else if (tab.equals(TAB_USER)) {
            indicator.setText("我的");
            drawable = getResources().getDrawable(R.mipmap.tab_user_normal);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            indicator.setCompoundDrawables(null, drawable, null, null);
            mUserTab = indicator;
        }
        return tabView;
    }

    TabHost.OnTabChangeListener listener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String tabId) {
            if (TAB_HOME.equals(tabId)) {
                position = 0;
                setHomeText(true);
                setMessageText(false);
                setAddText(false);
                setUserText(false);
                return;
            }
            if (TAB_MESSAGE.equals(tabId)) {
                position = 1;
                setHomeText(false);
                setMessageText(true);
                setAddText(false);
                setUserText(false);
                return;
            }
            if (TAB_RELEASE.equals(tabId)) {
                position = 2;
                setHomeText(false);
                setMessageText(false);
                setAddText(true);
                setUserText(false);
                return;
            }
            if (TAB_USER.equals(tabId)) {
                position = 3;
                setHomeText(false);
                setMessageText(false);
                setAddText(false);
                setUserText(true);
                return;
            }
        }
    };


    private void setHomeText(boolean isSelected) {
        Drawable drawable = null;
        if (isSelected) {
            mHomeTab.setTextColor(Color.RED);
            if (mHomePressed == null) {
                mHomePressed = getResources().getDrawable(
                        R.mipmap.tab_home_selected);
            }
            drawable = mHomePressed;
        } else {
            mHomeTab.setTextColor(Color.GRAY);
            if (mHomeNormal == null) {
                mHomeNormal = getResources().getDrawable(
                        R.mipmap.tab_home_normal);
            }
            drawable = mHomeNormal;
        }
        if (null != drawable) {// 此处出现过NP问题，加保护
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            mHomeTab.setCompoundDrawables(null, drawable, null, null);
        }

    }

    private void setMessageText(boolean isSelected) {
        Drawable drawable = null;
        if (isSelected) {
            mMessageTab.setTextColor(Color.RED);
            if (mMessagePressed == null) {
                mMessagePressed = getResources().getDrawable(
                        R.mipmap.tab_message_selected);
            }
            drawable = mMessagePressed;
        } else {
            mMessageTab.setTextColor(Color.GRAY);
            if (mMessageNormal == null) {
                mMessageNormal = getResources().getDrawable(
                        R.mipmap.tab_message_normal);
            }
            drawable = mMessageNormal;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            mMessageTab.setCompoundDrawables(null, drawable, null, null);
        }
    }


    private void setAddText(boolean isSelected) {
        Drawable drawable = null;
        if (isSelected) {
            mAddTab.setTextColor(Color.RED);
            if (mAddPressed == null) {
                mAddPressed = getResources().getDrawable(
                        R.mipmap.tab_add_selected);
            }
            drawable = mAddPressed;
        } else {
            mAddTab.setTextColor(Color.GRAY);
            if (mAddNormal == null) {
                mAddNormal = getResources().getDrawable(
                        R.mipmap.tab_add_normal);
            }
            drawable = mAddNormal;
        }
        if (null != drawable) {// 此处出现过NP问题，加保护
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            mAddTab.setCompoundDrawables(null, drawable, null, null);
        }

    }

    private void setUserText(boolean isSelected) {
        Drawable drawable = null;
        if (isSelected) {
            mUserTab.setTextColor(Color.RED);
            if (mUserPressed == null) {
                mUserPressed = getResources().getDrawable(
                        R.mipmap.tab_user_selected);
            }
            drawable = mUserPressed;
        } else {
            mUserTab.setTextColor(Color.GRAY);
            if (mUserNormal == null) {
                mUserNormal = getResources().getDrawable(
                        R.mipmap.tab_user_normal);
            }
            drawable = mUserNormal;
        }
        if (null != drawable) {// 此处出现过NP问题，加保护
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            mUserTab.setCompoundDrawables(null, drawable, null, null);
        }

    }



    private boolean isExit = false;

    /**设置2秒内点击手机系统返回按钮退出APP
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (position != 0) {
                position = 0;
                //如果不是在第一页 则回到第一页
                listener.onTabChanged(TAB_HOME);
                tabhost.onTabChanged(TAB_HOME);
                return true;
            } else if (!isExit) {
                isExit = true;
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                },2000);
                return true;
            }
        }

        return super.onKeyUp(keyCode, event);
    }

}
