package com.xunz.commonproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.utils.ToastUtil;
import com.xunz.commonproject.contract.LoginContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerHttpComponent;
import com.xunz.commonproject.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author Wangjingbo
 * @date 2018/7/30
 * describe 登录
 */
public class LoginActivity extends MyBaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.tvAccount)
    AutoCompleteTextView tvAccount;
    @BindView(R.id.tvPassword)
    EditText tvPassword;
    @BindView(R.id.btLogin)
    Button btLogin;

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
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
        showSuccess();
    }


    @OnClick(R.id.btLogin)
    public void onViewClicked() {
        mPresenter.login("15575163734", "123456");
    }


    @Override
    public void onSuccess(User user) {
        ToastUtil.showMessage("登录成功了");
    }
}

