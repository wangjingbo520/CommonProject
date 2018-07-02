package com.xunz.commonproject.dagger2.component;

import com.xunz.commonproject.ui.activity.LoginActivity;
import com.xunz.commonproject.ui.activity.RegisterActivity;

import dagger.Component;

/**
 * com.xunz.commonproject.dagger2.component
 *
 * @author 王静波
 * @date 2018/6/20
 * describe
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {

    /**
     * 注入方法
     *
     * @param registerActivity
     */
    void inject(RegisterActivity registerActivity);

    void inject(LoginActivity loginActivity);

}
