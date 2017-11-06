package com.tikeyc.tikeycandroid.fragment.main.tab;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.activity.main.PlayLiveActivity;
import com.tikeyc.tikeycandroid.bean.main.MyBannerLiveModel;
import com.tikeyc.tikeycandroid.common.Constants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tikeyc on 2017/10/24.
 * GitHub：https://github.com/tikeyc
 */

public class BannerFragment extends Fragment {


    @ViewInject(R.id.smartRefreshLayout)
    private SmartRefreshLayout smartRefreshLayout;

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;


    /////
    private MyRecyclerAdapter myRecyclerAdapter;
    private MyBannerLiveModel myBannerLiveModel;
    private List<MyBannerLiveModel.LivesBean> livesBeens;

    private Banner headViewBanner;
    private BannersModel bannersModel;
    public static List<BannersModel.DataBean.DetailBean> detailBeanList;
    private List<String> bannerTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_banner, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        initMyRecyclerAdapter();

        initListener();

        initData();

    }




    private void initView() {

        x.view().inject(this, getView());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        headViewBanner = new Banner(getActivity());
//        headViewBanner.setBackgroundColor(Color.GRAY);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtil.getScreenWidth(), DensityUtil.dip2px(200));
//        headViewBanner.setLayoutParams(layoutParams);
        headViewBanner = (Banner) LayoutInflater.from(getActivity()).inflate(R.layout.banner_head_view, recyclerView, false);
        headViewBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageOptions imageOptions = new ImageOptions.Builder()
                        .setImageScaleType(ImageView.ScaleType.FIT_XY)
                        .build();
                BannersModel.DataBean.DetailBean detailBean = ((BannersModel.DataBean.DetailBean) path);
                if (detailBean != null && detailBean.getCoverURL().size() > 0) {
                    x.image().bind(imageView, detailBean.getCoverURL().get(0), imageOptions);
                }
            }
        });
        //headViewBanner.setImages(BANNER_ITEMS);
        headViewBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //headViewBanner.start();

    }

    private void initMyRecyclerAdapter() {

        myRecyclerAdapter = new MyRecyclerAdapter();

        myRecyclerAdapter.addHeaderView(headViewBanner);


        recyclerView.setAdapter(myRecyclerAdapter);

    }

    private void initListener() {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getDataFromNet();
                getBannerDataFromNet();
            }
        });

        myRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), PlayLiveActivity.class);
                MyBannerLiveModel.LivesBean livesBean = (MyBannerLiveModel.LivesBean) adapter.getItem(position);
                intent.putExtra("stream_addr", livesBean.getStream_addr());
                startActivity(intent);
            }
        });

        headViewBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (detailBeanList != null && detailBeanList.size() > 0) {
                    BannersModel.DataBean.DetailBean detailBean = detailBeanList.get(position);
                    if (detailBean != null && detailBean.getPlayURL().size() > 0) {
                        Intent intent = new Intent(getActivity(), PlayLiveActivity.class);
                        intent.putExtra("stream_addr", detailBean.getPlayURL().get(0));
                        startActivity(intent);
                    }
                }
            }
        });
    }


    private void initData() {

        if (livesBeens != null && livesBeens.size() > 0) {
            myRecyclerAdapter.replaceData(livesBeens);

        } else {
            smartRefreshLayout.autoRefresh();

        }

        if (detailBeanList != null && detailBeanList.size() > 0) {
            headViewBanner.setImages(detailBeanList);
            headViewBanner.setBannerTitles(bannerTitles);
            headViewBanner.start();

        } else {
            smartRefreshLayout.autoRefresh();

        }



    }

    /**
     * 获取视频列表数据
     */
    private void getDataFromNet() {

        RequestParams params = new RequestParams(Constants.YINGKE_VIDEO_NET_URL);
        x.http().get(params, new Callback.CacheCallback<String >() {

            @Override
            public boolean onCache(String result) {
                paramsData(result);
//                getDataFromNet();
                return false;// true: 信任缓存数据, 不在发起网络请求; false不信任缓存数据.
            }

            @Override
            public void onSuccess(String result) {
                LogUtil.e("onSuccess"+result);
//                Log.e("TAG",result);
                //
                paramsData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError"+ex.getMessage());
                //刷新UI

            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished");
                smartRefreshLayout.finishRefresh();
            }
        });
    }

    /**
     * 获取视频列表数据
     */
    private void getBannerDataFromNet() {

        RequestParams params = new RequestParams(Constants.LIVE_VIDEO_NET_URL);
        x.http().get(params, new Callback.CacheCallback<String >() {

            @Override
            public boolean onCache(String result) {
                paramsBannerData(result);
//                getDataFromNet();
                return false;// true: 信任缓存数据, 不在发起网络请求; false不信任缓存数据.
            }

            @Override
            public void onSuccess(String result) {
                LogUtil.e("onSuccess"+result);
//                Log.e("TAG",result);
                //
                paramsBannerData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError"+ex.getMessage());
                //刷新UI

            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished");
                smartRefreshLayout.finishRefresh();
            }
        });
    }



    private void paramsData(String result) {

        myBannerLiveModel = new Gson().fromJson(result, MyBannerLiveModel.class);

        if (myBannerLiveModel == null) return;
        livesBeens = myBannerLiveModel.getLives();
        myRecyclerAdapter.replaceData(livesBeens);
        myRecyclerAdapter.notifyDataSetChanged();

    }


    private void paramsBannerData(String result) {

        bannersModel = new Gson().fromJson(result, BannersModel.class);

        if (bannersModel == null) return;
        detailBeanList = bannersModel.getData().getDetail();
        headViewBanner.setImages(detailBeanList);
        bannerTitles = new ArrayList<String >();
        for (BannersModel.DataBean.DetailBean detailBean : detailBeanList) {
            bannerTitles.add(detailBean.getVideoTitle());
        }
        headViewBanner.setBannerTitles(bannerTitles);
        headViewBanner.start();
    }



    public static class BannersModel {


        /**
         * Data : {"RetCode":0,"RetMsg":"success","Detail":[{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_328.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_1_large.png"],"VideoID":1,"VideoTitle":"ViVi鐩存挱闂�"},{"PlayURL":["rtmp://live.hkstv.hk.lxdns.com/live/hks"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_2_large.png"],"VideoID":2,"VideoTitle":"灏忎紮浼翠滑璧跺揩鏉ュ洿瑙�"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/0000011.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_3_large.png"],"VideoID":3,"VideoTitle":"钀岃悓鍝掔洿鎾棿"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_012.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_4_large.png"],"VideoID":4,"VideoTitle":"寮\u20ac鎾暒~"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_094.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_5_large.png"],"VideoID":5,"VideoTitle":"鎴戝彧鎯冲畨闈欏湴宸ヤ綔"}]}
         * RequestId :
         */

        private DataBean Data;
        private String RequestId;

        public DataBean getData() {
            return Data;
        }

        public void setData(DataBean Data) {
            this.Data = Data;
        }

        public String getRequestId() {
            return RequestId;
        }

        public void setRequestId(String RequestId) {
            this.RequestId = RequestId;
        }

        public static class DataBean {
            /**
             * RetCode : 0
             * RetMsg : success
             * Detail : [{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_328.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_1_large.png"],"VideoID":1,"VideoTitle":"ViVi鐩存挱闂�"},{"PlayURL":["rtmp://live.hkstv.hk.lxdns.com/live/hks"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_2_large.png"],"VideoID":2,"VideoTitle":"灏忎紮浼翠滑璧跺揩鏉ュ洿瑙�"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/0000011.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_3_large.png"],"VideoID":3,"VideoTitle":"钀岃悓鍝掔洿鎾棿"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_012.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_4_large.png"],"VideoID":4,"VideoTitle":"寮\u20ac鎾暒~"},{"PlayURL":["http://nemo.hdllive.ks-cdn.com/live/appdemo_094.flv"],"CoverURL":["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_5_large.png"],"VideoID":5,"VideoTitle":"鎴戝彧鎯冲畨闈欏湴宸ヤ綔"}]
             */

            private int RetCode;
            private String RetMsg;
            private List<DetailBean> Detail;

            public int getRetCode() {
                return RetCode;
            }

            public void setRetCode(int RetCode) {
                this.RetCode = RetCode;
            }

            public String getRetMsg() {
                return RetMsg;
            }

            public void setRetMsg(String RetMsg) {
                this.RetMsg = RetMsg;
            }

            public List<DetailBean> getDetail() {
                return Detail;
            }

            public void setDetail(List<DetailBean> Detail) {
                this.Detail = Detail;
            }

            public static class DetailBean {
                /**
                 * PlayURL : ["http://nemo.hdllive.ks-cdn.com/live/appdemo_328.flv"]
                 * CoverURL : ["http://ksy.vcloud.sdk.ks3-cn-beijing.ksyun.com/picture/live/image_1_large.png"]
                 * VideoID : 1
                 * VideoTitle : ViVi鐩存挱闂�
                 */

                private int VideoID;
                private String VideoTitle;
                private List<String> PlayURL;
                private List<String> CoverURL;

                public int getVideoID() {
                    return VideoID;
                }

                public void setVideoID(int VideoID) {
                    this.VideoID = VideoID;
                }

                public String getVideoTitle() {
                    return VideoTitle;
                }

                public void setVideoTitle(String VideoTitle) {
                    this.VideoTitle = VideoTitle;
                }

                public List<String> getPlayURL() {
                    return PlayURL;
                }

                public void setPlayURL(List<String> PlayURL) {
                    this.PlayURL = PlayURL;
                }

                public List<String> getCoverURL() {
                    return CoverURL;
                }

                public void setCoverURL(List<String> CoverURL) {
                    this.CoverURL = CoverURL;
                }
            }
        }
    }

    public static class MyRecyclerAdapter extends BaseQuickAdapter<MyBannerLiveModel.LivesBean, BaseViewHolder> {

        public MyRecyclerAdapter() {
            super(R.layout.fragment_banner_recycleview_item);
        }

        @Override
        protected void convert(BaseViewHolder helper, MyBannerLiveModel.LivesBean trailersBean) {
            //
            Glide.with(mContext).load(trailersBean.getCreator().getPortrait()).into((ImageView) helper.getView(R.id.portrait_head_iv));

            helper.setText(R.id.nick_tv, trailersBean.getCreator().getNick());

            helper.setText(R.id.city_tv, trailersBean.getCity());

            helper.setText(R.id.online_users_tv, trailersBean.getOnline_users() + "");

            Glide.with(mContext).load(trailersBean.getCreator().getPortrait()).into((ImageView) helper.getView(R.id.show_portrait_iv));

        }


    }



}
