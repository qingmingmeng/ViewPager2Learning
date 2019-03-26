package com.example.viewpager2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpager2.R;
import com.example.viewpager2.utils.UiUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by zhangjie on 2019/3/25 15:53
 * Description:
 * Passed parameters:
 * Warning:
 */
public class CFragment extends Fragment {

    private View view;
    private TextView tvC;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {//经过测试这个方法不会被执行
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("C Fragment 生命周期", "执行了非生命周期方法 setUserVisibleHint：" + isVisibleToUser);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("C Fragment 生命周期", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("C Fragment 生命周期", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_c,container,false);
        tvC = view.findViewById(R.id.tv_c);
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtil.toast("C Fragment");
            }
        });
        Log.e("C Fragment 生命周期", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("C Fragment 生命周期", "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("C Fragment 生命周期", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("C Fragment 生命周期", "onResume");
    }
}
