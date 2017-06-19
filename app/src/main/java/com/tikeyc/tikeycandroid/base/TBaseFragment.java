package com.tikeyc.tikeycandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by tikeyc on 2017/6/15.
 * GitHub：https://github.com/tikeyc
 */

public abstract class TBaseFragment extends Fragment {

    public View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView();
    }

    /**
     * 由子类强制实现
     */
    public abstract View createView();

}
