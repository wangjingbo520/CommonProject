package com.xunz.commonproject.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xunz.commonproject.MainActivity;
import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.ui.activity.LoginActivity;
import com.xunz.commonproject.ui.activity.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity1 extends MyBaseActivity {

    @Override
    public void onRetry() {
        showSuccess();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test1;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }


    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        setTitle("首页");
    }

    @Override
    public void initData() {
        showSuccess();
    }


    @OnClick({R.id.tvMain, R.id.tvLogin, R.id.tvRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvMain:
                startTo(MainActivity.class);
                break;
            case R.id.tvLogin:
                startTo(LoginActivity.class);
                break;
            case R.id.tvRegister:
                startTo(RegisterActivity.class);
                break;
            default:
                break;
        }
    }

}
