package com.xunz.commonproject;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;

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
    private static MyApplication sMyApp;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        initData();

//        mApplicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this))
//                .httpModule(new HttpModule())
//                .build();
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


    public static MyApplication getInstance() {
        return sMyApp;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}

