package com.tikeyc.tikeycandroid.fragment.tab;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.AnimatorPath;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathEvaluator;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathPoint;
import com.tikeyc.tikeycandroid.custom.CustomView.PathView;

import org.w3c.dom.Text;
import org.xutils.common.util.DensityUtil;

import java.util.ArrayList;

/**
 * Created by public1 on 2017/4/24.
 */

public class THomeFragment extends Fragment implements View.OnClickListener {

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
        fab = (TextView) mView.findViewById(R.id.fab);
        fab.setOnClickListener(this);

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



    /*设置动画路径*/
    public void setPath(){
        path = new AnimatorPath();
//        path.moveTo(0,0);
//        path.lineTo(400,400);
//        path.secondBesselCurveTo(600, 200, 800, 400);
//        path.thirdBesselCurveTo(100,600,900,1000,200,1200);
        int radius = pathView.getWidth() - 400;
        Rect rect = new Rect(-radius,pathView.getHeight()/2 - radius,radius,pathView.getHeight()/2 + radius);
        RectF oval = new RectF(rect);
        path.addArc(oval,90,-180);
    }

    /**
     * 设置动画
     * @param view 使用动画的View
     * @param propertyName 属性名字
     * @param path 动画路径集合
     */
    private void startAnimatorPath(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(3000);
        anim.setRepeatCount(4);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.start();
    }

    /**
     *   ObjectAnimator动画原理

         ObjectAnimator.ofObject(….,”xxx”,估值值,区间数组); 【定义动画属性xxx和区间】

         插值器/加速器（Interpolator）【返回当前数字进度t】

         估值值（Evaluator）【根当前数字进度计算并返回当前值】

         调用setXxx函数 【根据封装好的setXxx函数并反射调用，将第三步返回当前值以参数传入】
     * 设置View的属性通过ObjectAnimator.ofObject()的反射机制来调用
     * @param newLoc
     */
    public void setFab(PathPoint newLoc) {
//        fab.setTranslationX(newLoc.mX);
//        fab.setTranslationY(newLoc.mY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fab.getLayoutParams();
        layoutParams.leftMargin = (int) (newLoc.mX - layoutParams.width/2);
        layoutParams.topMargin = (int) (newLoc.mY - layoutParams.height/2);
        layoutParams.width = 150;
        layoutParams.height = 60;
        fab.setLayoutParams(layoutParams);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                startAnimatorPath(fab, "fab", path);
                break;
        }
    }
}
