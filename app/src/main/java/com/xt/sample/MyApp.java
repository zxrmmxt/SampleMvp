package com.xt.sample;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author xt on 2020/4/17 12:25
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
