package com.tikeyc.tikeycandroid.custom.ScrollView;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by public1 on 2017/6/2.
 */

public class THorizontalListView extends ListView {

    private int listView_width;
    private int listView_height;
    private THorizontalListAdapter horizontalListAdapter;

    public THorizontalListView(Context context) {
        this(context,null);
    }

    public THorizontalListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public THorizontalListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void init() {

        rotationListView();

        horizontalListAdapter = new THorizontalListAdapter();
        setAdapter(horizontalListAdapter);
    }

    /**逆时针旋转90°
     *setRotation(-90); 默认是已view的中心点旋转，所以先根据最终旋转后显示的位置，先更改view的位置到初始旋转的合适位置，然后再旋转90°就会显示在你所希望的位置
     * 如下图：由默认的竖向已中心点旋转为横向

             * * * * *
             *       *
             *       *
       * * * * * * * * * * *
       *     *       *     *
       *     *       *     *
       * * * * * * * * * * *
             *       *
             *       *
             * * * * *

     */
    private void rotationListView() {

        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);
                int left = getLeft();
                int top = getTop();
                int right = getRight();
                int bottom = getBottom();
                int width = right - left;
                int height = bottom - top;
                Log.e("TAG","getWidth():" + getWidth() + "--" + "getHeight():" + getHeight());
                Log.e("TAG","left:" + left + "--" + "top:" + top + "--" + "width:" + width + "--" + "height:" + height);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = layoutParams.leftMargin + (width - height)/2;//将view已到默认的旋转中心点
                layoutParams.topMargin = layoutParams.topMargin + (height - width)/2;//将view已到默认的旋转中心点
                listView_width = width;
                listView_height = height;
                layoutParams.width = height;//旋转后的宽是旋转前的高
                layoutParams.height = width;//旋转后的高是旋转前的宽
                setLayoutParams(layoutParams);
                Log.e("TAG","left:" + left + "--" + "top:" + top + "--" + "width:" + width + "--" + "height:" + height);
                setRotation(-90);
                Log.e("TAG","left2:" + getLeft() + "--" + "top2:" + getTop() + "--" + "width:" + width + "--" + "height:" + height);
                return true;
            }
        });
    }


    public class THorizontalListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (dataSource != null) return dataSource.getCount();
            return 0;
        }

        @Override
        public Object getItem(int i) {
            if (dataSource != null) return dataSource.getItem(i);
            return null;
        }

        @Override
        public long getItemId(int i) {
            if (dataSource != null) return dataSource.getItemId(i);
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (dataSource != null) {
                view = dataSource.getView(i,view,viewGroup);
                //再将item顺时针旋转90° 宽是旋转后的高(item的宽度)，高是旋转后的宽（item的高度）
                ViewTreeObserver treeObserver = view.getViewTreeObserver();
                final View finalView = view;
                treeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
//                        int width = finalView.getWidth();
//                        int height = finalView.getHeight();
//                        finalView.setPivotX(width/2);
//                        finalView.setPivotY(listView_height/2);
                        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(listView_height,listView_height);
                        finalView.setLayoutParams(layoutParams);
                        finalView.setRotation(90);

                        return true;
                    }
                });

                return view;
            }

            return view;
        }
    }


    private THorizontalListAdapterDatasource dataSource;

    public void setDataSource(THorizontalListAdapterDatasource dataSource) {
        this.dataSource = dataSource;
        horizontalListAdapter.notifyDataSetChanged();

    }

    public THorizontalListAdapterDatasource getDataSource() {
        return dataSource;
    }

    public interface THorizontalListAdapterDatasource {
        int getCount();
        Object getItem(int i);
        long getItemId(int i);
        View getView(int i, View view, ViewGroup viewGroup);
    }

}
