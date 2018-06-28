package com.xunz.commonproject.dagger2.component;

import com.xunz.commonproject.ui.activity.RegisterActivity;

import dagger.Component;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {

    //注入方法
    void inject(RegisterActivity registerActivity);

}
