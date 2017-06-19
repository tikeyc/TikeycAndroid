package com.tikeyc.tikeycandroid.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.bean.home.THomeBaiSiBuDeJieModel;

import java.util.List;

/**
 * Created by public1 on 2017/6/14.
 */

public class TBaiSiBuDeJieListAdapter extends BaseMultiItemQuickAdapter<THomeBaiSiBuDeJieModel, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TBaiSiBuDeJieListAdapter(List<THomeBaiSiBuDeJieModel> data) {
        super(data);

        addItemType(0, R.layout.bai_si_bu_de_jie_list_item );
    }

    @Override
    protected void convert(BaseViewHolder helper, THomeBaiSiBuDeJieModel item) {

        switch (helper.getItemViewType()) {
            case 0:{
                ImageView imageView = helper.getView(R.id.icon_iv);

            }
            break;
            case 1:{

            }
            break;
            default:
                break;
        }

    }


}
