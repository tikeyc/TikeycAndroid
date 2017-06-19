package com.tikeyc.tikeycandroid.fragment.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.user.THomeUserAdapter;
import com.tikeyc.tikeycandroid.base.TBaseFragment;
import com.tikeyc.tikeycandroid.bean.user.THomeUserItem;
import com.tikeyc.tikeycandroid.custom.ScrollView.TStretchableListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class TUserFragment extends TBaseFragment {

    @ViewInject(R.id.recyclerView)
    private TStretchableListView recyclerView;
    private THomeUserAdapter homeUserAdapter;
    private ArrayList<THomeUserItem> userTitles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View createView() {
        mView = (LinearLayout) View.inflate(getContext(), R.layout.user_fragment,null);

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
