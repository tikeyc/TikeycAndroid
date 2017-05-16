package com.tikeyc.tikeycandroid.fragment.tab;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.AnimatorPath;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathEvaluator;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.PathPoint;

import org.w3c.dom.Text;

/**
 * Created by public1 on 2017/4/24.
 */

public class THomeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout mView;

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
        this.fab = (TextView) mView.findViewById(R.id.fab);
        setPath();

        fab.setOnClickListener(this);

    }


    private AdapterView.OnItemClickListener gridItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    };


    private AdapterView.OnItemClickListener listItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    };

    /*设置动画路径*/
    public void setPath(){
        path = new AnimatorPath();
        path.moveTo(0,0);
        path.lineTo(400,400);
        path.secondBesselCurveTo(600, 200, 800, 400);
        path.thirdBesselCurveTo(100,600,900,1000,200,1200);
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
     * 设置View的属性通过ObjectAnimator.ofObject()的反射机制来调用
     * @param newLoc
     */
    public void setFab(PathPoint newLoc) {
        fab.setTranslationX(newLoc.mX);
        fab.setTranslationY(newLoc.mY);
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
