package com.tikeyc.tikeycandroid.adapter.user;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.bean.user.THomeUserAttentionItem;

import java.util.List;

/**
 * Created by public1 on 2017/5/31.
 */

public class THomeUserAttentionAdapter extends BaseQuickAdapter<THomeUserAttentionItem,BaseViewHolder> {

    public THomeUserAttentionAdapter(int layoutResId, List<THomeUserAttentionItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, THomeUserAttentionItem item) {
        LinearLayout itemSuperView = helper.getView(R.id.item_superview);
        itemSuperView.setRotation(90);
        helper.setText(R.id.nickName_tv,item.getUserName());
    }

}
