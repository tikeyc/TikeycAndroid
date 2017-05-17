package com.tikeyc.tikeycandroid.custom.AnimatorPath;


import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by zhengliang on 2016/10/15 0015.
 * 估值器类,实现坐标点的计算
 */

public class PathEvaluator implements TypeEvaluator<PathPoint> {

    /**贝塞尔曲线介绍与公式:http://www.2cto.com/kf/201604/497130.html
     *
     * @param t          :执行的百分比
     * @param startValue : 起点
     * @param endValue   : 终点
     * @return
     */
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        // 返回一个路径信息，其中包含偏移坐标x和偏移坐标y。
        // 【返回用于反射调用setFabLoc时函数的传参】、

        // startValue:前一个操作路径 endValue：后一个操作路径 t：操作进度(0->1)
        // startValue和endValue为传入的路径集合数组中相邻的两个路径

        float x, y;
        float oneMiunsT = 1 - t;
        //三阶贝塞尔曲线
        if (endValue.mOperation == PathPoint.THIRD_CURVE) {
            x = startValue.mX*oneMiunsT*oneMiunsT*oneMiunsT+3*endValue.mContorl0X*t*oneMiunsT*oneMiunsT+3*endValue.mContorl1X*t*t*oneMiunsT+endValue.mX*t*t*t;
            y = startValue.mY*oneMiunsT*oneMiunsT*oneMiunsT+3*endValue.mContorl0Y*t*oneMiunsT*oneMiunsT+3*endValue.mContorl1Y*t*t*oneMiunsT+endValue.mY*t*t*t;
            //二阶贝塞尔曲线
        }else if(endValue.mOperation == PathPoint.SECOND_CURVE){
            x = oneMiunsT*oneMiunsT*startValue.mX+2*t*oneMiunsT*endValue.mContorl0X+t*t*endValue.mX;
            y = oneMiunsT*oneMiunsT*startValue.mY+2*t*oneMiunsT*endValue.mContorl0Y+t*t*endValue.mY;
            //直线
        }else if (endValue.mOperation == PathPoint.LINE) {
            //x起始点+t*起始点和终点的距离
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        }else if (endValue.mOperation == PathPoint.CIRCLE) {
            float radius = endValue.oval.width()/2;
            PointF center = new PointF(endValue.oval.left + radius,endValue.oval.top + radius);

            float hudu = (float) (Math.PI/(180/Math.abs(endValue.sweepAngle)));
            x = (float) (Math.sin(hudu*t)*radius + center.x);
            y = (float) (Math.cos(hudu*t)*radius + center.y);

        } else {
            x = endValue.mX;
            y = endValue.mY;
        }
        return PathPoint.moveTo(x,y);
    }
}
