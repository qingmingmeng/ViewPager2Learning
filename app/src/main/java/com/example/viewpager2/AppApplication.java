package com.example.viewpager2;

import android.app.Application;

/**
 * Created by zhangjie on 2019/3/26 9:20
 * Description:
 * Passed parameters:
 * Warning:
 */
public class AppApplication extends Application {
    private static AppApplication CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
    }

    public static AppApplication getInstance() {
        if (null == CONTEXT) {
            CONTEXT = new AppApplication();
        }
        return CONTEXT;
    }
}
