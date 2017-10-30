package com.tikeyc.tikeycandroid.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.bean.main1.home.TWaterFlowModel;
import com.tikeyc.tnineplacegridviewlibrary.TNinePlaceGridView.TScallImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tikeyc on 2017/6/16.
 * GitHub：https://github.com/tikeyc
 */

public class TWaterFlowAdapter extends RecyclerView.Adapter<TWaterFlowAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TScallImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (TScallImageView) itemView.findViewById(R.id.imageView);
        }
    }

    private Context context;

    public List<TWaterFlowModel.ResultsBean> list;//数据
    private List<Integer> heightList;//装产出的随机数


    private OnRecyclerItemClickListener mOnItemClickListener;//单击事件
    private onRecyclerItemLongClickListener mOnItemLongClickListener;//长按事件

    public TWaterFlowAdapter(Context context, List<TWaterFlowModel.ResultsBean> list) {
        this.context = context;
        this.list = list;

        //记录为每个控件产生的随机高度,避免滑回到顶部出现空白
        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(400) + 300;//[300,700)的随机数
            heightList.add(height);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //找到item的布局
        View view = LayoutInflater.from(context).inflate(R.layout.water_flow_item_layout,parent,false);
        return new MyViewHolder(view);//将布局设置给holder
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //填充数据
//        holder.imageView.setImageResource(R.mipmap.beauty);
        Picasso.with(context).load(list.get(position).getUrl()).into(holder.imageView);
        //由于需要实现瀑布流的效果,所以就需要动态的改变控件的高度了
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        params.height = heightList.get(position);
        holder.imageView.setLayoutParams(params);

        //设置点击放大全屏
        holder.imageView.imageId = list.get(position).getUrl();
        holder.imageView.currentIndex = position;
        ArrayList<Object> imageIds = new ArrayList<Object>();
        imageIds.add(list.get(position).getUrl());
        holder.imageView.imageIds = imageIds;
        holder.imageView.ninePlaceGridView = (ViewGroup) holder.imageView.getParent();

        //设置单击事件 如果外部设置了该单机事件，则点击图片全屏放大浏览功能将被覆盖
        if(mOnItemClickListener != null){
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mOnItemClickListener.onItemClick(v,position);这里需要获取布局中的position,不然乱序
                    mOnItemClickListener.onItemClick(v,holder.getLayoutPosition());
                }
            });
        }
        //长按事件
        if(mOnItemLongClickListener != null){
            holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //回调出去
                    mOnItemLongClickListener.onItemLongClick(v,holder.getLayoutPosition());
                    return true;//不返回true,松手还会去执行单击事件
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ////////////////////////////////////////

    /**
     * 处理item的点击事件,因为recycler没有提供单击事件,所以只能自己写了
     */
    public interface OnRecyclerItemClickListener {
        public void onItemClick(View view, int position);
    }

    /**
     * 长按事件
     */
    public interface  onRecyclerItemLongClickListener{
        public void onItemLongClick(View view, int position);
    }

    /**
     * 暴露给外面的设置单击事件
     */
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * 暴露给外面的长按事件
     */
    public void setOnItemLongClickListener(onRecyclerItemLongClickListener onItemLongClickListener){
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 向指定位置添加元素
     */
    public void addItem(int position, TWaterFlowModel.ResultsBean value) {
        if(position > list.size()) {
            position = list.size();
        }
        if(position < 0) {
            position = 0;
        }
        /**
         * 使用notifyItemInserted/notifyItemRemoved会有动画效果
         * 而使用notifyDataSetChanged()则没有
         */
        list.add(position, value);//在集合中添加这条数据
        heightList.add(position,new Random().nextInt(400) + 200);//[200,600)的随机数,添加一个随机高度,会在onBindViewHolder方法中得到设置
        notifyItemInserted(position);//通知插入了数据
    }

    /**
     * 移除指定位置元素
     */
    public TWaterFlowModel.ResultsBean removeItem(int position) {
        if(position > list.size()-1) {
            return null;
        }
        heightList.remove(position);//删除添加的高度
        TWaterFlowModel.ResultsBean value = list.remove(position);//所以还需要手动在集合中删除一次
        notifyItemRemoved(position);//通知删除了数据,但是没有删除list集合中的数据
        return value;
    }



}
