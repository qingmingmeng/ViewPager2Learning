package com.example.viewpager2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.MyRecyclerAdapter;
import com.example.viewpager2.R;
import com.example.viewpager2.interfaces.OnItemClickListener;
import com.example.viewpager2.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class VerticalSlidePicActivity extends Activity {

    public static String TYPE = "type";
    public static int VERTICAL = 0x1001;
    public static int HORIZONTAL = 0x1002;

    private int type;
    private AlphaAnimation alphaAnimation;
    private List<Integer> images = new ArrayList<>();
    private ViewPager2 viewPager2;
    private LinearLayout llIndicator;
    private List<View> indicatorViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slide);

        llIndicator = findViewById(R.id.ll_indicator);

        alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        //获取数据传输
        Intent intent = getIntent();
        if (null != intent) {
            type = intent.getIntExtra(TYPE,0);
        }
        /*数据源数据 start*/
        images.add(R.mipmap.image_1);
        images.add(R.mipmap.image_2);
        images.add(R.mipmap.image_3);
        images.add(R.mipmap.image_4);
        /*数据源数据 end*/
        /*重组数据，为了设置可以轮播 start*/
        final List<Integer> datas = new ArrayList<>();
        datas.add(images.get(images.size()-1));
        datas.addAll(images);
        datas.add(images.get(0));
        /*重组数据，为了设置可以轮播 end*/

        //添加指示器
        for (int i = 0 ; i < images.size() ; i++){
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) UiUtil.dip2px(6), (int) UiUtil.dip2px(6));
            params.setMargins((int) UiUtil.dip2px(4),0,(int) UiUtil.dip2px(4),0);
            view.setLayoutParams(params);
            if (i == 0) {
                view.setBackgroundResource(R.drawable.shape_circle_white);
            } else {
                view.setBackgroundResource(R.drawable.shape_circle_gray);
            }
            llIndicator.addView(view);
            indicatorViews.add(view);
        }

        viewPager2 = findViewById(R.id.view_pager_2);
        MyRecyclerAdapter myAdapter = new MyRecyclerAdapter(datas,R.layout.item,this,alphaAnimation);
        viewPager2.setAdapter(myAdapter);
        viewPager2.setCurrentItem(1,false);
        if (type == VERTICAL) {
            //纵向滑动
            viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        } else {
            //横向滑动
            viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        }

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
                //设置指示器
                if (position == 0) {
                    setIndicatorBg(3);
                } else if (position == 5) {
                    setIndicatorBg(0);
                } else {
                    setIndicatorBg(position - 1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                // ViewPager.SCROLL_STATE_IDLE 标识的状态是当前页面完全展现，并且没有动画正在进行中，如果不
                // 是此状态下执行 setCurrentItem 方法回在首位替换的时候会出现跳动！
                if (state != ViewPager.SCROLL_STATE_IDLE) return;
                if (currentPisition == 0) {
                    viewPager2.setCurrentItem(datas.size() - 2, false);
                } else if (currentPisition == datas.size() - 1) {
                    viewPager2.setCurrentItem(1,false);
                }
            }
        });
    }

    //设置指示器颜色
    private void setIndicatorBg(int position){
        for (int i = 0 ; i < indicatorViews.size() ; i++){
            if (i == position) {
                indicatorViews.get(i).setBackgroundResource(R.drawable.shape_circle_white);
            } else {
                indicatorViews.get(i).setBackgroundResource(R.drawable.shape_circle_gray);
            }
        }
    }
}
