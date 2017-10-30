package com.tikeyc.tikeycandroid.adapter.user;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.bean.main1.user.THomeUserItem;
import com.tikeyc.tikeycandroid.custom.ScrollView.THorizontalListView;

import java.util.List;

/**
 * Created by public1 on 2017/5/31.
 */

public class THomeUserAdapter extends BaseMultiItemQuickAdapter<THomeUserItem, BaseViewHolder> {

    private Context context;

    public THomeUserAdapter(Context context, List<THomeUserItem> data) {
        super(data);
        this.context = context;
        addItemType(THomeUserItem.User_Attentions,R.layout.home_user_attention_listview);
        addItemType(THomeUserItem.User_Normal,R.layout.home_user_list_item);
    }


    @Override
    protected void convert(BaseViewHolder helper, THomeUserItem item) {

        switch (helper.getItemViewType()) {
            case THomeUserItem.User_Attentions: {
//                final RecyclerView listView = helper.getView(R.id.listView);
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listView.getLayoutParams();
//                layoutParams.width = DensityUtil.getScreenWidth();
//                layoutParams.height = DensityUtil.getScreenWidth();
//                listView.setLayoutParams(layoutParams);
//                GridLayoutManager manager = new GridLayoutManager(context, 1);
//                listView.setLayoutManager(manager);
//                List<THomeUserAttentionItem> data = new ArrayList<THomeUserAttentionItem>();
//                for (int i = 0; i < 20; i++) {
//                    THomeUserAttentionItem tHomeUserAttentionItem = new THomeUserAttentionItem(R.mipmap.glenceluanch,"name:" + i);
//                    data.add(tHomeUserAttentionItem);
//                }
//                final THomeUserAttentionAdapter attentionAdapter = new THomeUserAttentionAdapter(R.layout.home_user_attention_list_item,data);
//                listView.setAdapter(attentionAdapter);
//                listView.setRotation(-90);
                final THorizontalListView listView = helper.getView(R.id.listView);
                listView.setDataSource(new THorizontalListView.THorizontalListAdapterDatasource() {
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
                        view = View.inflate(context,R.layout.home_user_attention_list_item,null);
                        return view;
                    }
                });

            }
            break;
            case THomeUserItem.User_Normal: {
                helper.setText(R.id.title_tv,item.getTitle());
            }
            break;
            default:
                break;
        }

    }


}
