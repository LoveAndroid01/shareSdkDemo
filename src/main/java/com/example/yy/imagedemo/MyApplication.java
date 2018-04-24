package com.example.yy.imagedemo;

import android.app.Application;

import com.mob.MobSDK;


/**
 * Created by yy on 2018/4/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
    }
}
