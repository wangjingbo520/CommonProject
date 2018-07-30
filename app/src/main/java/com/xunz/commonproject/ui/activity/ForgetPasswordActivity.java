package com.xunz.commonproject.ui.activity;

import android.os.Bundle;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.contract.ForgetPassContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerHttpComponent;
import com.xunz.commonproject.presenter.ForgetPasswordPresenter;

/**
 * @author Wangjingbo
 * @date 2018/7/30
 * describe 忘记密码
 */
public class ForgetPasswordActivity extends MyBaseActivity<ForgetPasswordPresenter> implements ForgetPassContract {

    @Override
    public int getContentLayout() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(android.view.View view, Bundle savedInstanceState) {

    }



    @Override
    public void initData() {

    }

    @Override
    public void onRetry() {
        initData();
    }
}
