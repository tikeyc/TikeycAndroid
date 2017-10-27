package com.tikeyc.tikeycandroid.adapter.home;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.bean.home.THomeBaiSiBuDeJieModel;
import com.tikeyc.tikeycandroid.libs.CircleImageView;

import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by public1 on 2017/6/14.
 */

public class TBaiSiBuDeJieListAdapter extends BaseMultiItemQuickAdapter<THomeBaiSiBuDeJieModel.ListBean, BaseViewHolder> {



    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TBaiSiBuDeJieListAdapter(List<THomeBaiSiBuDeJieModel.ListBean> data) {
        super(data);

        addItemType(THomeBaiSiBuDeJieModel.ListBean.TYPE_VIDEO, R.layout.bai_si_bu_de_jie_list_all_video_item );
        addItemType(THomeBaiSiBuDeJieModel.ListBean.TYPE_IMAGE, R.layout.bai_si_bu_de_jie_list_all_image_item );
        addItemType(THomeBaiSiBuDeJieModel.ListBean.TYPE_GIF, R.layout.bai_si_bu_de_jie_list_all_gif_item );
        addItemType(THomeBaiSiBuDeJieModel.ListBean.TYPE_TEXT, R.layout.bai_si_bu_de_jie_list_all_text_item );
        addItemType(THomeBaiSiBuDeJieModel.ListBean.TYPE_AD, R.layout.bai_si_bu_de_jie_list_all_ad_item );
    }


    @Override
    protected void convert(BaseViewHolder helper, THomeBaiSiBuDeJieModel.ListBean audioItem) {

        //video,text,image,gif,ad

        switch (helper.getItemViewType()){
            case THomeBaiSiBuDeJieModel.ListBean.TYPE_VIDEO:{
                bindData(helper,audioItem);
                //第一个参数是视频地址，第二个是显示封面地址，第三个是标题
                THomeBaiSiBuDeJieModel.ListBean.VideoBean videoBean = audioItem.getVideo();
                JCVideoPlayerStandard jcVideoPlayerStandard = helper.getView(R.id.jcv_videoplayer);
                jcVideoPlayerStandard.setUp(videoBean.getVideo().get(0), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
                Picasso.with(mContext).load(videoBean.getThumbnail().get(0)).into(jcVideoPlayerStandard.thumbImageView);
                TextView tv_play_name = helper.getView(R.id.tv_play_name);
                tv_play_name.setText(videoBean.getPlaycount() + "次播放");
                TextView tv_video_duration = helper.getView(R.id.tv_video_duration);
                tv_video_duration.setText(videoBean.getDuration() + "");

                if (audioItem.getTop_comments() != null && audioItem.getTop_comments().size() > 0 && audioItem.getTop_comments().get(0).getContent() != null) {
                    TextView tv_commant_context = helper.getView(R.id.tv_commant_context);
                    tv_commant_context.setText(audioItem.getTop_comments().get(0).getContent());
                }


            }
            break;
            case THomeBaiSiBuDeJieModel.ListBean.TYPE_IMAGE:{
                bindData(helper,audioItem);

//                viewHolder.iv_image_icon.setImageResource(R.drawable.bg_item);
                int height = audioItem.getImage().getHeight() <= DensityUtil.getScreenHeight()*0.75?audioItem.getImage().getHeight() : (int)(DensityUtil.getScreenHeight()*0.75);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.getScreenWidth(),height);
                helper.getView(R.id.iv_image_icon).setLayoutParams(params);
                if (audioItem.getImage() != null && audioItem.getImage().getBig() != null && audioItem.getImage().getBig().size() > 0) {
//                    x.image().bind(viewHolder.iv_image_icon,audioItem.getImage().getBig().get(0));
//                    Glide.with(context).load(audioItem.getImage().getBig().get(0)).placeholder(null)
//                            .error(null).diskCacheStrategy(DiskCacheStrategy.ALL).
//                            into(viewHolder.iv_image_icon);
                    ImageView iv_image_icon = (ImageView) helper.getView(R.id.iv_image_icon);
                    Picasso.with(mContext).load(audioItem.getImage().getBig().get(0)).placeholder(null).into(iv_image_icon);
                }
            }
            break;
            case THomeBaiSiBuDeJieModel.ListBean.TYPE_GIF:{
                bindData(helper,audioItem);
                Log.e("TAG","audioItem.getGif().getImages().get(0)" + audioItem.getGif().getImages().get(0));
                GifImageView gifImageView = helper.getView(R.id.iv_image_gif);
                Glide.with(mContext).load(audioItem.getGif().getImages().get(0)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gifImageView);

            }
            break;
            case THomeBaiSiBuDeJieModel.ListBean.TYPE_TEXT:{
                bindData(helper,audioItem);
            }
            break;
            case THomeBaiSiBuDeJieModel.ListBean.TYPE_AD:{
//                bindData(viewHolder,audioItem);
            }
            break;
            default:
                break;
        }

        //设置文本
        TextView tv_content = helper.getView(R.id.tv_content);
        tv_content.setText(audioItem.getText());

    }


    /**绑定公共数据
     * @param viewHolder
     * @param audioItem
     */
    private void bindData(BaseViewHolder viewHolder, THomeBaiSiBuDeJieModel.ListBean audioItem) {

        if (audioItem.getU() != null && audioItem.getU().getHeader() != null && audioItem.getU().getHeader().get(0) != null) {
            CircleImageView circleImageView = (CircleImageView) viewHolder.getView(R.id.iv_headpic);
            Picasso.with(mContext).load(audioItem.getU().getHeader().get(0)).placeholder(null).into(circleImageView);
        }

        if (audioItem.getU() != null && audioItem.getU().getName() != null) {
            TextView tv_name = viewHolder.getView(R.id.tv_name);
            tv_name.setText(audioItem.getU().getName() + "");
        }

        TextView tv_time_refresh = viewHolder.getView(R.id.tv_time_refresh);
        tv_time_refresh.setText(audioItem.getPasstime());

        //设置标签
        List<THomeBaiSiBuDeJieModel.ListBean.TagsBean> tagsBean = audioItem.getTags();
        if (tagsBean != null && tagsBean.size() > 0) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < tagsBean.size(); i++ ) {
                buffer.append(tagsBean.get(i).getName() + " ");
            }
            TextView tv_video_kind_text = viewHolder.getView(R.id.tv_video_kind_text);
            if (tv_video_kind_text != null) tv_video_kind_text.setText(buffer.toString());
        }

        //设置点赞，踩，转发
        TextView tv_shenhe_ding_number = viewHolder.getView(R.id.tv_shenhe_ding_number);
        tv_shenhe_ding_number.setText(audioItem.getUp());
        TextView tv_shenhe_cai_number = viewHolder.getView(R.id.tv_shenhe_cai_number);
        tv_shenhe_cai_number.setText(audioItem.getDown() + "");
        TextView tv_posts_number = viewHolder.getView(R.id.tv_posts_number);
        tv_posts_number.setText(audioItem.getForward() + "");
    }
}
