package com.tikeyc.tikeycandroid.custom.TPathCustomView;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tikeyc.tikeycandroid.custom.AnimatorPath.AnimatorPath;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathEvaluator;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathPoint;

/**
 * Created by public1 on 2017/5/17.
 */

public class TPathIcon extends LinearLayout {

    public static final String Animation_Property_Name = "animationPropertyName";

    public String animationPropertyName;
    public AnimatorPath path;

    public AnimatorPath getPath() {
        return path;
    }

    public void setPath(AnimatorPath path) {
        this.path = path;
    }

    public TPathIcon(Context context) {
        super(context);
    }

    public TPathIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TPathIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void startAnimatorPath(long duration, long startDelay) {
        if (path == null)return;
        ObjectAnimator anim = ObjectAnimator.ofObject(this, Animation_Property_Name, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(duration);
//        anim.setRepeatCount(4);
//        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setStartDelay(startDelay);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        anim.start();
    }

    /**
     * 设置动画
     * @param view 使用动画的View
     * @param propertyName 属性名字
     * @param path 动画路径集合
     */
    public void startAnimatorPath(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(3000);
//        anim.setRepeatCount(4);
//        anim.setRepeatMode(ObjectAnimator.REVERSE);
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
    public void setAnimationPropertyName(PathPoint newLoc) {
//        setTranslationX(newLoc.mX);
//        setTranslationY(newLoc.mY);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) (newLoc.mX - 100);//根据具体的icon设置的大小减去相应宽度
        layoutParams.topMargin = (int) (newLoc.mY - 60);//根据具体的icon设置的大小减去相应高度
        setLayoutParams(layoutParams);
    }



}
