package com.tikeyc.tikeycandroid.fragment.main.tab;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.activity.main1.TMainFragmentTabActivity;

import org.xutils.common.util.LogUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * Created by tikeyc on 2017/10/24.
 * GitHub：https://github.com/tikeyc
 */

public class HomeFragment extends Fragment {

    @Event(value = R.id.homeButton,
    type = View.OnClickListener.class)
    private void homeButtonOnClick(View view) {
        Intent intent = new Intent(getActivity(), TMainFragmentTabActivity.class);
        startActivity(intent);
        BGASwipeBackHelper.executeForwardAnim(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

    }

    private void initView() {
        x.view().inject(this, this.getView());

    }



}
