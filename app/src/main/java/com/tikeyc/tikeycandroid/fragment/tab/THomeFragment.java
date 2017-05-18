package com.tikeyc.tikeycandroid.fragment.tab;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.AnimatorPath;
import com.tikeyc.tikeycandroid.custom.CustomView.PathView;


import java.util.ArrayList;

/**
 * Created by public1 on 2017/4/24.
 */

public class THomeFragment extends Fragment  {

    private LinearLayout mView;
    private PathView pathView;

    private TextView fab;
    private AnimatorPath path;//声明动画集合

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = (LinearLayout) inflater.inflate(R.layout.home_fragment,container,false);

        initView();

        return mView;
    }

    private void initView() {
        pathView = (PathView) mView.findViewById(R.id.pathView);

        final ArrayList<Integer> iconImageNames = new ArrayList<>();
        final ArrayList<String> iconsTitles = new ArrayList<>();
        iconImageNames.add(R.mipmap.path_animation_icon);
        iconImageNames.add(R.mipmap.path_animation_icon);
        iconImageNames.add(R.mipmap.path_animation_icon);
        iconImageNames.add(R.mipmap.path_animation_icon);
        iconImageNames.add(R.mipmap.path_animation_icon);
        iconsTitles.add("test1");
        iconsTitles.add("test2");
        iconsTitles.add("test3");
        iconsTitles.add("test4");
        iconsTitles.add("test5");
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

//                setPath();
//                startAnimatorPath(fab, "fab", path);
                pathView.setShowPathIcons(iconImageNames,iconsTitles);
                pathView.postInvalidate();
            }
        };
        handler.sendEmptyMessageDelayed(0, (long) 1);

    }



}
