package com.tikeyc.tikeycandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.home.TWaterFlowAdapter;

import org.xutils.common.util.LogUtil;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class TWaterFlowActivity extends Activity {

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;
    private List<String> listData;
    private TWaterFlowAdapter waterFlowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_twater_flow);

        initData();

        initView();

        setListen();
    }

    private void initData() {
        listData = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++){
            listData.add("" + (char) i);
        }

    }

    private void initView() {
        x.view().inject(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        waterFlowAdapter = new TWaterFlowAdapter(this,listData);
        recyclerView.setAdapter(waterFlowAdapter);

    }

    private void setListen() {
        //添加点击事件
        waterFlowAdapter.setOnItemClickListener(new TWaterFlowAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(TWaterFlowActivity.this,"单击了:"+mDatas.get(position),Toast.LENGTH_SHORT).show();
                waterFlowAdapter.addItem(position,"添加的内容");
                LogUtil.e("onItemClick: "+position);
            }
        });

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


}
