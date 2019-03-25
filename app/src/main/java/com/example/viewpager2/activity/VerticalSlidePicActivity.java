package com.example.viewpager2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.viewpager2.adapter.MyRecyclerAdapter;
import com.example.viewpager2.R;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager2.widget.ViewPager2;

public class VerticalSlidePicActivity extends Activity {

    //private Animation animation;
    private AlphaAnimation alphaAnimation;
    private List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slide);

        //animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        images.add(R.mipmap.image_1);
        images.add(R.mipmap.image_2);
        images.add(R.mipmap.image_3);
        images.add(R.mipmap.image_4);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager_2);
        MyRecyclerAdapter myAdapter = new MyRecyclerAdapter(images,R.layout.item,this,alphaAnimation);
        viewPager2.setAdapter(myAdapter);
    }
}
