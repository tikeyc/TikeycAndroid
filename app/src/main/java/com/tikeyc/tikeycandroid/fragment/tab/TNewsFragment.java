package com.tikeyc.tikeycandroid.fragment.tab;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagCloudView;
import com.moxun.tagcloudlib.view.TagsAdapter;
import com.tikeyc.tikeycandroid.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class TNewsFragment extends Fragment {

    private LinearLayout mView;
    @ViewInject(R.id.tagCloudView_3D)
    private TagCloudView tagCloudView_3D;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = (LinearLayout) inflater.inflate(R.layout.news_fragment,container,false);

        initView();

        return mView;
    }

    private void initView() {

        x.view().inject(this,mView);

        T3DTagCloudViewAdapter adapter = new T3DTagCloudViewAdapter();
        tagCloudView_3D.setAdapter(adapter);

    }




    private class T3DTagCloudViewAdapter extends TagsAdapter {

        /**返回Tag数量
         * @return
         */
        @Override
        public int getCount() {
            return 50;
        }

        /**返回每个Tag实例
         * @param context
         * @param position
         * @param parent
         * @return
         */
        @Override
        public View getView(Context context, int position, ViewGroup parent) {

            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(60, 60);
            textView.setLayoutParams(lp);
            textView.setText("" + position);
            textView.setGravity(Gravity.CENTER);

            return textView;
        }

        /**返回Tag数据
         * @param position
         * @return
         */
        @Override
        public Object getItem(int position) {
            return null;
        }

        /**针对每个Tag返回一个权重值，该值与ThemeColor和Tag初始大小有关
         * @param position
         * @return
         */
        @Override
        public int getPopularity(int position) {
            return position % 7;
        }

        /**Tag主题色发生变化时会回调该方法
         * @param view
         * @param themeColor
         */
        @Override
        public void onThemeColorChanged(View view, int themeColor) {
//            Log.e("TAG","onThemeColorChanged");
            ((TextView)view).setBackgroundColor(themeColor);
        }
    }
}
