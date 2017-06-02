package com.tikeyc.tikeycandroid.fragment.tab;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.user.THomeUserAdapter;
import com.tikeyc.tikeycandroid.bean.THomeUserItem;
import com.tikeyc.tikeycandroid.custom.ScrollView.TStretchableListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class TUserFragment extends Fragment {

    private LinearLayout mView;
    @ViewInject(R.id.recyclerView)
    private TStretchableListView recyclerView;
    private THomeUserAdapter homeUserAdapter;
    private ArrayList<THomeUserItem> userTitles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = (LinearLayout) inflater.inflate(R.layout.user_fragment,container,false);

        initView();

        initData();

        initAdapter();


        return mView;
    }


    private void initView() {
        x.view().inject(this,mView);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(manager);

    }

    private void initData() {
        userTitles = new ArrayList<THomeUserItem>();
        for (int i = 0; i < 6; i++) {
            THomeUserItem homeUserItem;
            if (i == 0) {
                homeUserItem = new THomeUserItem(THomeUserItem.User_Attentions,"item-" + i);
            } else {
                homeUserItem = new THomeUserItem(THomeUserItem.User_Normal,"item-" + i);
            }

            userTitles.add(homeUserItem);
        }
    }



    private void initAdapter() {

        homeUserAdapter = new THomeUserAdapter(getContext(),userTitles);
        final View header = View.inflate(getContext(),R.layout.home_user_header,null);
        recyclerView.setZoomView(header);
        homeUserAdapter.addHeaderView(header);
        recyclerView.setAdapter(homeUserAdapter);

    }


}
