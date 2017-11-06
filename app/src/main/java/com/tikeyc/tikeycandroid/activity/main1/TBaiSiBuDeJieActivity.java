package com.tikeyc.tikeycandroid.activity.main1;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.home.TBaiSiBuDeJieListAdapter;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.bean.main1.home.THomeBaiSiBuDeJieModel;
import com.tikeyc.tikeycandroid.common.Constants;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.jzvd.JZVideoPlayer;


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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

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
                return false;// true: 信任缓存数据, 不在发起网络请求; false不信任缓存数据.
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
        if (homeBaiSiBuDeJieModel == null) return;

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

        if (listAdapter == null) {
            listAdapter = new TBaiSiBuDeJieListAdapter(homeBaiSiBuDeJieModel.getList());
            listAdapter.np = homeBaiSiBuDeJieModel.getInfo().getNp();
            recyclerView.setAdapter(listAdapter);
        } else {
            int lastNp = listAdapter.np;
            int currentNp = homeBaiSiBuDeJieModel.getInfo().getNp();

            if (lastNp != currentNp) {
                listAdapter.addData(0,homeBaiSiBuDeJieModel.getList());
            } else {
                listAdapter.replaceData(homeBaiSiBuDeJieModel.getList());
            }

            listAdapter.notifyDataSetChanged();
        }



    }


    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}
