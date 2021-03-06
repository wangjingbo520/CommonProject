package com.xunz.commonproject.dagger2.component;

import com.xunz.commonproject.ui.activity.ForgetPasswordActivity;
import com.xunz.commonproject.ui.activity.LoginActivity;
import com.xunz.commonproject.ui.activity.RegisterActivity;
import com.xunz.commonproject.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * com.xunz.commonproject.dagger2.component
 *
 * @author wangjingbo
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

    void inject(HomeFragment homeFragment);

    void inject(ForgetPasswordActivity forgetPasswordActivity);

}
