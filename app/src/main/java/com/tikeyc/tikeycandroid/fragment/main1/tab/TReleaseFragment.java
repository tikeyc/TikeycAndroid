package com.tikeyc.tikeycandroid.fragment.main1.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.base.TBaseFragment;
import com.tikeyc.tikeycandroid.custom.ScrollView.THorizontalListView;

public class TReleaseFragment extends TBaseFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View createView() {
        mView = (LinearLayout) View.inflate(getContext(), R.layout.release_fragment,null);

        initView();

        return mView;
    }

    private void initView() {

        final THorizontalListView horizontalListView = (THorizontalListView) mView.findViewById(R.id.tHorizontalListView);
        horizontalListView.setBackgroundColor(Color.BLUE);
        horizontalListView.setDataSource(new THorizontalListView.THorizontalListAdapterDatasource() {

            class ViewHolder {

            }

            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ViewHolder viewHolder;
                if (view == null) {
                    viewHolder = new ViewHolder();
                    view = View.inflate(getContext(),R.layout.release_home_image_list_item,null);
                    //宽是高，高是宽
                    view.setTag(viewHolder);

                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                return view;
            }
        });

    }

}
