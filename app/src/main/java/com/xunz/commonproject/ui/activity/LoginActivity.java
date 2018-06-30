package com.xunz.commonproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.common.utils.MD5Helper;
import com.xunz.commonproject.contract.LoginContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A login screen that offers login via email/password.
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
//        DaggerHttpComponent.builder()
//                .applicationComponent(appComponent)
//                .build()
//                .inject(this);

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
        mPresenter.login("liunian", MD5Helper.encrypt32WithKey("123456"), 0);
    }

    @Override
    public void getData(Object object) {

    }
}

