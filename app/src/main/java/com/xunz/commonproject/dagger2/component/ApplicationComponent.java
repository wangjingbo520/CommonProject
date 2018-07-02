package com.xunz.commonproject.dagger2.component;

import android.content.Context;

import com.xunz.commonproject.MyApplication;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.dagger2.module.ApplicationModule;
import com.xunz.commonproject.dagger2.module.HttpModule;

import dagger.Component;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {
    MyApplication getApplication();

    Context getContext();

    RequestClient getNetEaseApi();

}
