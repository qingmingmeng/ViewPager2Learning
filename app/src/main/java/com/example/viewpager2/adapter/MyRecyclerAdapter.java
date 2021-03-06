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
import com.example.viewpager2.interfaces.OnItemClickListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhangjie on 2019/3/6 14:39
 * Description:
 * Passed parameters:
 * Warning:
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<Integer> datas;
    private int viewId;
    private Context context;

    public MyRecyclerAdapter(List<Integer> datas, int viewId, Context context){
        this.datas = datas;
        this.viewId = viewId;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(viewId,null,false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        itemView.setLayoutParams(params);
        itemView.setOnClickListener(this);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder hd = (MyHolder) holder;
        hd.itemView.setTag(position);
        hd.imageView.setImageResource(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public void onClick(View v) {
        if (null != listener) {
            listener.onItemClick(v, (int) v.getTag());
        }
    }

    private static final class MyHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
