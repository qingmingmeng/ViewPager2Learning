package com.example.viewpager2.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Created by zhangjie on 2019/3/25 15:08
 * Description:
 * Passed parameters:
 * Warning:
 */
public class MyFragmentStateAdapter extends FragmentStateAdapter {

    private List<Fragment> fragments;

    public MyFragmentStateAdapter(@NonNull FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (null != fragments && fragments.size() > position){
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return null == fragments ? 0 : fragments.size();
    }
}
