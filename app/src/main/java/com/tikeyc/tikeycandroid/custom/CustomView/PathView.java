package com.tikeyc.tikeycandroid.custom.CustomView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.custom.AnimatorPath.AnimatorPath;

import java.util.ArrayList;

/**
 * 时 间: 2016/11/8 0008
 * 作 者: 郑亮
 * Q  Q : 1023007219
 */

public class PathView extends RelativeLayout {

    private Paint paint;
    private ArrayList<TPathIcon> pathIcons = new ArrayList<TPathIcon>();

    private ArrayList<Integer> iconImageNames;
    private ArrayList<String> iconsTitles;


    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        initView();
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }


    private void initView() {
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);
        //设置画笔未实心
        paint.setStyle(Paint.Style.STROKE);
        //设置颜色
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        //设置画笔宽度
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
//        path.moveTo(60,60);
//        path.lineTo(460,460);
//        path.quadTo(660, 260, 860, 460); //订单
//        path.cubicTo(160,660,960,1060,260,1260);
        RectF oval = getOval();
        path.addArc(oval,90,-180);
        canvas.drawPath(path,paint);
    }


    ///////////

    public void setShowPathIcons(ArrayList<Integer> iconImageNames, ArrayList<String> iconsTitles) {

        this.iconImageNames = iconImageNames;
        this.iconsTitles = iconsTitles;
        int count = iconsTitles.size() + 1;
        for (int i = 0; i < iconsTitles.size(); i++) {
            TPathIcon icon = (TPathIcon) View.inflate(getContext(),R.layout.path_animation_icon, null);
            icon.setTag(i);
            icon.setPath(initPath(90,-(180/count)*(i + 1)));
            pathIcons.add(icon);
            ImageView iv = (ImageView) icon.findViewById(R.id.icon_image);
            TextView tv = (TextView) icon.findViewById(R.id.icon_title);
            tv.setText(iconsTitles.get(i));
            addView(icon);
            icon.setVisibility(INVISIBLE);

            icon.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("TIKEYC","PathIcon Click");
                    if (pathIconClickListen != null) {
                        pathIconClickListen.onPathIconClick((TPathIcon) view);
                    }
                }
            });
        }

        startAnimation();
    }

    private RectF getOval() {
        int radius = getWidth() - 500;
        Rect rect = new Rect(-radius,getHeight()/2 - radius,radius,getHeight()/2 + radius);
        RectF oval = new RectF(rect);
        return oval;
    }

    /*设置动画路径*/
    public AnimatorPath initPath(float startAngle, float sweepAngle){
        AnimatorPath path = new AnimatorPath();
//        path.moveTo(0,0);
//        path.lineTo(400,400);
//        path.secondBesselCurveTo(600, 200, 800, 400);
//        path.thirdBesselCurveTo(100,600,900,1000,200,1200);
        RectF oval = getOval();
        path.addArc(oval,startAngle,sweepAngle);
//        path.addArc(oval,90,-180);
        return path;
    }

    public void startAnimation() {
        int count = pathIcons.size();
        for (int i = count - 1 ; i >= 0; --i) {
            TPathIcon pathIcon = pathIcons.get(i);
            long duration = 800;
            long startDelay = (count - 1 - i) * (duration/count);
            pathIcon.startAnimatorPath(duration - startDelay,startDelay);

        }
    }

    ///////////
    private TPathIconClickListen pathIconClickListen;

    public void addPathIconClickListener(PathView.TPathIconClickListen listener) {
        pathIconClickListen = listener;
    }

    public interface TPathIconClickListen {
        void onPathIconClick(TPathIcon pathIcon);
    }

}
