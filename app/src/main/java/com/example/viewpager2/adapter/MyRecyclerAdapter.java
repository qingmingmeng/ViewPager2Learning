package com.example.viewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.viewpager2.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhangjie on 2019/3/6 14:39
 * Description:
 * Passed parameters:
 * Warning:
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter {

    private List<Integer> datas;
    private int viewId;
    private Context context;
    private Animation animation;

    public MyRecyclerAdapter(List<Integer> datas, int viewId, Context context, Animation animation){
        this.datas = datas;
        this.viewId = viewId;
        this.context = context;
        this.animation = animation;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(viewId,null,false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        itemView.setLayoutParams(params);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder hd = (MyHolder) holder;
        hd.imageView.setImageResource(datas.get(position));
        if (position == 0){
            hd.tvGuide.setVisibility(View.VISIBLE);
            hd.tvGuide.startAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    private static final class MyHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView tvGuide;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            tvGuide = itemView.findViewById(R.id.tv_guide);
        }
    }
}
