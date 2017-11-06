package com.tikeyc.tikeycandroid.myApplication;

import android.app.Application;
import android.os.Handler;

import com.dou361.baseutils.utils.LogType;
import com.dou361.baseutils.utils.UtilsManager;

import org.xutils.x;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * Created by public1 on 2017/4/24.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xUtils
        x.Ext.init(this);


        /**
         * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
         */
        BGASwipeBackHelper.init(this, null);


        /** 初始化sdk */
        UtilsManager.init(this, "", new Handler(), Thread.currentThread());
        /** 设置debug模式，默认为false为正式环境不输出日志 */
        UtilsManager.getInstance().setDebugEnv(true);
        /** 设置日志输出等级 */
        UtilsManager.getInstance().setLogLevel(LogType.LEVEL_ERROR);

    }



}
