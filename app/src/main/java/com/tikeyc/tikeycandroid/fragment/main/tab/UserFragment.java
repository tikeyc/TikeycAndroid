package com.tikeyc.tikeycandroid.fragment.main.tab;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.activity.user.TLoginActivity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by tikeyc on 2017/10/25.
 * GitHub：https://github.com/tikeyc
 */

public class UserFragment extends Fragment {

    private int mOffset = 0;
    private int mScrollY = 0;

    @ViewInject(R.id.parallax)
    private ImageView parallax;

    @ViewInject(R.id.refreshLayout)
    private SmartRefreshLayout refreshLayout;

    @ViewInject(R.id.scrollView_user)
    private NestedScrollView scrollView;

    @ViewInject(R.id.logout_bt)
    private Button logout_bt;

    @Event(value = {R.id.logout_bt},
    type = View.OnClickListener.class)
    private void buttonOnClickListener(View view) {
        if (view.getId() == R.id.logout_bt) {
            Intent intent = new Intent(getActivity(), TLoginActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView();

        initListener();
    }



    private void initView() {

        x.view().inject(this, this.getView());

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

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            private int lastScrollY = 0;
            private int h = DensityUtil.dp2px(170);
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    parallax.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });

    }



}
