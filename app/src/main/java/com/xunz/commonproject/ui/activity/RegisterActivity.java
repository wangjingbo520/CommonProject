package com.xunz.commonproject.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.contract.RegisterContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerHttpComponent;
import com.xunz.commonproject.presenter.RegisterPresenter;

/**
 * @author Wangjingbo
 * @date 2018/7/30
 * describe 注册
 */
public class RegisterActivity extends MyBaseActivity<RegisterPresenter> implements
        RegisterContract.View {

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {
        mPresenter.postRegisterInfo("", "", "");
    }


    @Override
    public void getData(User user) {

    }
}
