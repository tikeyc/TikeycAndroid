package com.tikeyc.tikeycandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.home.TBaiSiBuDeJieListAdapter;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.bean.home.THomeBaiSiBuDeJieModel;

import org.xutils.common.util.LogUtil;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class TBaiSiBuDeJieActivity extends TBaseActivity {

    @ViewInject(R.id.swipe_refreshLayout)
    private SwipeRefreshLayout swipeRefreshLayout;
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData() {
        List<THomeBaiSiBuDeJieModel> data = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            THomeBaiSiBuDeJieModel model = new THomeBaiSiBuDeJieModel();
            data.add(model);
        }
        listAdapter = new TBaiSiBuDeJieListAdapter(data);
        recyclerView.setAdapter(listAdapter);
    }

    private void setListen() {

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtil.d("onRefresh");
                listAdapter.setEnableLoadMore(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        listAdapter.setEnableLoadMore(true);
                    }
                }, 2000);
            }
        });

        listAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                LogUtil.d("onLoadMoreRequested");
                swipeRefreshLayout.setEnabled(false);

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

//                        listAdapter.loadMoreComplete();
                        listAdapter.loadMoreEnd(true);
                        swipeRefreshLayout.setEnabled(true);
                    }
                }, 2000);
            }
        });

    }


}
