package com.xunz.commonproject.common.component;

import android.content.Context;


import com.xunz.commonproject.common.module.ApplicationModule;
import com.xunz.commonproject.common.module.HttpModule;

import dagger.Component;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(modules = {ApplicationModule.class,HttpModule.class})
public interface ApplicationComponent {

//    MyApp getApplication();
//
//    NewsApi getNetEaseApi();
//
//    JanDanApi getJanDanApi();

    Context getContext();

}
