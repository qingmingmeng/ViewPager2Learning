package com.example.viewpager2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.viewpager2.R;
import com.example.viewpager2.adapter.MyFragmentStateAdapter;
import com.example.viewpager2.fragment.AFragment;
import com.example.viewpager2.fragment.BFragment;
import com.example.viewpager2.fragment.CFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class VerticalSlideFrgActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private MyFragmentStateAdapter myFragmentStateAdapter;
    private TextView tvA;
    private TextView tvB;
    private TextView tvC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slide_frg);

        List<Fragment> fragments = new ArrayList<>();
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        CFragment cFragment = new CFragment();
        fragments.add(aFragment);
        fragments.add(bFragment);
        fragments.add(cFragment);

        tvA = findViewById(R.id.tv_a);
        tvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor(0);
                viewPager2.setCurrentItem(0,true);
            }
        });
        tvB = findViewById(R.id.tv_b);
        tvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor(1);
                viewPager2.setCurrentItem(1,true);
            }
        });
        tvC = findViewById(R.id.tv_c);
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor(2);
                viewPager2.setCurrentItem(2,true);
            }
        });

        setColor(0);//默认选中第一个tag项

        viewPager2 = findViewById(R.id.view_pager_2);
        FragmentManager manager = getSupportFragmentManager();
        myFragmentStateAdapter = new MyFragmentStateAdapter(manager,fragments);
        viewPager2.setAdapter(myFragmentStateAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setColor(position);
            }
        });
    }

    private void setColor(int position){
        if (0 == position) {
            tvA.setTextColor(getResources().getColor(R.color.choosed));
            tvA.setBackgroundColor(getResources().getColor(R.color.gray));
            tvB.setTextColor(getResources().getColor(R.color.unChoosed));
            tvB.setBackgroundColor(getResources().getColor(R.color.white));
            tvC.setTextColor(getResources().getColor(R.color.unChoosed));
            tvC.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (1 == position) {
            tvA.setTextColor(getResources().getColor(R.color.unChoosed));
            tvA.setBackgroundColor(getResources().getColor(R.color.white));
            tvB.setTextColor(getResources().getColor(R.color.choosed));
            tvB.setBackgroundColor(getResources().getColor(R.color.gray));
            tvC.setTextColor(getResources().getColor(R.color.unChoosed));
            tvC.setBackgroundColor(getResources().getColor(R.color.white));
        } else {
            tvA.setTextColor(getResources().getColor(R.color.unChoosed));
            tvA.setBackgroundColor(getResources().getColor(R.color.white));
            tvB.setTextColor(getResources().getColor(R.color.unChoosed));
            tvB.setBackgroundColor(getResources().getColor(R.color.white));
            tvC.setTextColor(getResources().getColor(R.color.choosed));
            tvC.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }
}
