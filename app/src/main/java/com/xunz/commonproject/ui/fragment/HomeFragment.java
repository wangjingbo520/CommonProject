package com.xunz.commonproject.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.BaseFragment;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.utils.MD5Helper;
import com.xunz.commonproject.common.utils.ToastUtil;
import com.xunz.commonproject.contract.LoginContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerHttpComponent;
import com.xunz.commonproject.dagger2.module.ApplicationModule;
import com.xunz.commonproject.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * @author wangjingbo
 * @date 2018/6/27
 * describe
 */
public class HomeFragment extends BaseFragment<LoginPresenter> implements LoginContract.View {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
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
        mPtrFrameLayout.disableWhenHorizontalMove(true);
    }

    @Override
    public void onRetry() {
        super.onRetry();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showSuccess();
            }
        }, 2000);
    }

    @Override
    public void initData() {
        showSuccess();
        // showEmptyView();
    }


    @OnClick(R.id.button)
    public void onViewClicked() {
        //登录
        if (mPresenter == null) {
            ToastUtil.showMessage("mPresenter==null");
            return;
        }
        mPresenter.login("15575163734", "123456");
    }


    @Override
    public void onSuccess(User user) {

    }
}
