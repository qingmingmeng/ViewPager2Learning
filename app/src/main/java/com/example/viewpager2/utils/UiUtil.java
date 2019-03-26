package com.example.viewpager2.utils;

import android.widget.Toast;

import com.example.viewpager2.AppApplication;

/**
 * 弹窗、Toast等工具类
 */
public class UiUtil {

    /**
     * 单例Toast
     * <p>
     * toast禁止用于网络请求返回时的提示，因为用户可能看不到
     */
    private static ToastCompat toastCompat;
    public static void toast(String msg) {
        if (null==toastCompat) {
            toastCompat=new ToastCompat();
        }
        toastCompat.showToast(AppApplication.getInstance(),msg, Toast.LENGTH_SHORT);
    }

    /*屏幕中心toast*/
    public static void toastCenter(String msg) {
        if (null==toastCompat) {
            toastCompat=new ToastCompat();
        }
        toastCompat.showToastCenter(AppApplication.getInstance(),msg, Toast.LENGTH_SHORT);
    }
}