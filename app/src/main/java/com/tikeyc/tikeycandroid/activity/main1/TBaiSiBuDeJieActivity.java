package com.tikeyc.tikeycandroid.activity.main1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.home.TBaiSiBuDeJieListAdapter;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.bean.home.THomeBaiSiBuDeJieModel;
import com.tikeyc.tikeycandroid.common.Constants;

import org.json.JSONException;
import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class TBaiSiBuDeJieActivity extends TBaseActivity {

    @ViewInject(R.id.swipe_refreshLayout)
    private SmartRefreshLayout smartRefreshLayout;
    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;

    private TBaiSiBuDeJieListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbai_si_bu_de_jie);


        initView();

        initData();

        setListen();
    }


    private void initView() {
        x.view().inject(this);

        navigationBar_title_tv.setText("百思不得姐");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData() {

//        getDataFromNet();
        smartRefreshLayout.autoRefresh();

    }



    private void setListen() {

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getDataFromNet();
            }
        });


    }


    /**
     * 获取百思不得姐列表数据
     */
    private void getDataFromNet() {

        final RequestParams params = new RequestParams(Constants.AUDIO_NET_URL);
        x.http().get(params, new Callback.CacheCallback<String >() {

            @Override
            public boolean onCache(String result) {
                paramsData(result);
//                getDataFromNet();
                return true;
            }

            @Override
            public void onSuccess(String result) {
                LogUtil.e("onSuccess"+result);
//                Log.e("TAG",result);
                //
                paramsData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError"+ex.getMessage());
                //刷新UI

            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished");
                smartRefreshLayout.finishRefresh();
            }
        });
    }

    private void paramsData(String result) {

        THomeBaiSiBuDeJieModel homeBaiSiBuDeJieModel = new Gson().fromJson(result, THomeBaiSiBuDeJieModel.class);

        for (THomeBaiSiBuDeJieModel.ListBean listBean : homeBaiSiBuDeJieModel.getList()) {
            //video,text,image,gif,ad
            int itemViewTye = -1;
            String type = listBean.getType();
            if (type.equals("video")) {
                itemViewTye = THomeBaiSiBuDeJieModel.ListBean.TYPE_VIDEO;
            } else if (type.equals("image")) {
                itemViewTye = THomeBaiSiBuDeJieModel.ListBean.TYPE_IMAGE;
            } else if (type.equals("gif")) {
                itemViewTye = THomeBaiSiBuDeJieModel.ListBean.TYPE_GIF;
            } else if (type.equals("text")) {
                itemViewTye = THomeBaiSiBuDeJieModel.ListBean.TYPE_TEXT;
            } else {
                itemViewTye = THomeBaiSiBuDeJieModel.ListBean.TYPE_AD;
            }
            listBean.setItemType(itemViewTye);
        }

        listAdapter = new TBaiSiBuDeJieListAdapter(homeBaiSiBuDeJieModel.getList());
        recyclerView.setAdapter(listAdapter);

    }


    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
