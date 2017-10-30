package com.tikeyc.tikeycandroid.activity.main1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.home.TWaterFlowAdapter;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.bean.main1.home.TWaterFlowModel;
import com.tikeyc.tikeycandroid.common.Constants;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class TWaterFlowActivity extends TBaseActivity {

    @ViewInject(R.id.smartRefreshLayout)
    private SmartRefreshLayout smartRefreshLayout;

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;

    private List<String> listData;
    private TWaterFlowAdapter waterFlowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_twater_flow);

        initView();

        setListen();

        initData();
    }

    private void initData() {

        smartRefreshLayout.autoRefresh();

    }

    private void initView() {
        x.view().inject(this);
        int clomu = 2;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(clomu,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setListen() {

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getDataFromNet();
            }
        });

    }

    private void setWaterFlowAdaptetListener() {
        //添加点击事件
//        waterFlowAdapter.setOnItemClickListener(new TWaterFlowAdapter.OnRecyclerItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                //Toast.makeText(TWaterFlowActivity.this,"单击了:"+mDatas.get(position),Toast.LENGTH_SHORT).show();
////                waterFlowAdapter.addItem(position,null);
//                LogUtil.e("onItemClick: "+position);
//            }
//        });

        //设置长按事件
        waterFlowAdapter.setOnItemLongClickListener(new TWaterFlowAdapter.onRecyclerItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(TWaterFlowActivity.this,"长按了:"+mDatas.get(position),Toast.LENGTH_SHORT).show();
                waterFlowAdapter.removeItem(position);
                LogUtil.e("onItemLongClick: "+position);
            }
        });
    }


    private void getDataFromNet() {

        final RequestParams params = new RequestParams(Constants.PIC_SEX);
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

        TWaterFlowModel waterFlowModel = new Gson().fromJson(result,TWaterFlowModel.class);

        if (waterFlowAdapter == null) {
            List<TWaterFlowModel.ResultsBean> resultsBeanList = waterFlowModel.getResults();
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            waterFlowAdapter = new TWaterFlowAdapter(this,resultsBeanList);
            setWaterFlowAdaptetListener();
            recyclerView.setAdapter(waterFlowAdapter);
        } else {
            List<TWaterFlowModel.ResultsBean> resultsBeanList = waterFlowModel.getResults();
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            resultsBeanList.addAll(resultsBeanList);
            waterFlowAdapter.list = resultsBeanList;

            waterFlowAdapter.notifyDataSetChanged();
        }


    }


}
