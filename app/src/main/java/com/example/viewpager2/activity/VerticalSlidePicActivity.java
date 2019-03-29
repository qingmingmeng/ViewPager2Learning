package com.example.viewpager2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.viewpager2.adapter.MyRecyclerAdapter;
import com.example.viewpager2.R;
import com.example.viewpager2.interfaces.OnItemClickListener;
import com.example.viewpager2.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class VerticalSlidePicActivity extends Activity {

    private AlphaAnimation alphaAnimation;
    private List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slide);

        alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        /*数据源数据 start*/
        images.add(R.mipmap.image_1);
        images.add(R.mipmap.image_2);
        images.add(R.mipmap.image_3);
        images.add(R.mipmap.image_4);
        /*数据源数据 end*/
        final ViewPager2 viewPager2 = findViewById(R.id.view_pager_2);
        final List<Integer> datas = new ArrayList<>();
        datas.add(images.get(images.size()-1));
        datas.addAll(images);
        datas.add(images.get(0));
        MyRecyclerAdapter myAdapter = new MyRecyclerAdapter(datas,R.layout.item,this,alphaAnimation);
        viewPager2.setAdapter(myAdapter);
        viewPager2.setCurrentItem(1,false);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                UiUtil.toast("第" + position + "张图片");
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            int currentPisition;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPisition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if (state != ViewPager.SCROLL_STATE_IDLE) return;
                if (currentPisition == 0) {
                    viewPager2.setCurrentItem(datas.size() - 2, false);
                } else if (currentPisition == datas.size() - 1) {
                    viewPager2.setCurrentItem(1,false);
                }
            }
        });
    }
}
