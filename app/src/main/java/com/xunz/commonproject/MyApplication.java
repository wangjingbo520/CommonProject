package com.xunz.commonproject;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.xunz.commonproject.center.model.User;
import com.xunz.commonproject.common.component.ApplicationComponent;

import java.io.File;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * com.xunz.commonproject.base
 *
 * @author 王静波
 * @date 2018/6/20
 * describe
 */
public class MyApplication  extends Application {
    public static String BASEPATH = Environment.getExternalStorageDirectory().getPath() +
            "/stinfo/";
    public static SharedPreferences pref;
    public static Application appContext;
    public static Context context;

    //当前用户
    public static User user;

    public static String deviceId = "";
    public static String deviceVersion = "";
    private ApplicationComponent mApplicationComponent;
    private static MyApplication sMyApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        initData();
    }

    private void initData() {
        appContext = this;
        context = this;
        BGASwipeBackManager.getInstance().init(this);
        pref = getSharedPreferences("stinfo", MODE_PRIVATE);
        initPath();
    }

    private void initPath() {
        File file = new File(BASEPATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static MyApplication getInstance() {
        return sMyApp;
    }
}

