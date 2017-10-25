package com.tikeyc.tikeycandroid.fragment.main1.tab;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.adapter.user.THomeUserAdapter;
import com.tikeyc.tikeycandroid.base.TBaseFragment;
import com.tikeyc.tikeycandroid.bean.user.THomeUserItem;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import static android.R.attr.scrollY;

public class TUserFragment extends TBaseFragment {

    private int mOffset = 0;
    private int mScrollY = 0;

    @ViewInject(R.id.parallax)
    private ImageView parallax;

    @ViewInject(R.id.refreshLayout)
    private SmartRefreshLayout refreshLayout;

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;

    private THomeUserAdapter homeUserAdapter;

    private ArrayList<THomeUserItem> userTitles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View createView() {
        mView = (FrameLayout) View.inflate(getContext(), R.layout.user_fragment,null);

        initView();

        initData();

        initAdapter();

        initListener();

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
//        final View header = View.inflate(getContext(),R.layout.home_user_header,null);
//        recyclerView.setZoomView(header);
//        homeUserAdapter.addHeaderView(header);
        recyclerView.setAdapter(homeUserAdapter);

    }


    private void initListener() {

        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int bottomHeight, int extendHeight) {
                mOffset = offset / 2;
                parallax.setTranslationY(mOffset - mScrollY);
//                toolbar.setAlpha(1 - Math.min(percent, 1));
            }
            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int bottomHeight, int extendHeight) {
                mOffset = offset / 2;
                parallax.setTranslationY(mOffset - mScrollY);
//                toolbar.setAlpha(1 - Math.min(percent, 1));
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                private int lastScrollY = 0;
                private int h = DensityUtil.dp2px(170);
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    int scrollY = i1;
                    if (lastScrollY < h) {
                        scrollY = Math.min(h, scrollY);
                        mScrollY = scrollY > h ? h : scrollY;
                        parallax.setTranslationY(mOffset - mScrollY);
                    }
                    lastScrollY = scrollY;
                }
            });
        }

//        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            private int lastScrollY = 0;
//            private int h = DensityUtil.dp2px(170);
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (lastScrollY < h) {
//                    scrollY = Math.min(h, scrollY);
//                    mScrollY = scrollY > h ? h : scrollY;
//                    parallax.setTranslationY(mOffset - mScrollY);
//                }
//                lastScrollY = scrollY;
//            }
//        });

    }


}
