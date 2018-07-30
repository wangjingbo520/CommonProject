package com.xunz.commonproject.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.BaseFragment;
import com.xunz.commonproject.common.utils.MD5Helper;
import com.xunz.commonproject.common.utils.ToastUtil;
import com.xunz.commonproject.contract.LoginContract;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;
import com.xunz.commonproject.dagger2.component.DaggerHttpComponent;
import com.xunz.commonproject.presenter.LoginPresenter;

import butterknife.OnClick;

/**
 * com.xunz.commonproject.fragment
 *
 * @author 王静波
 * @date 2018/6/27
 * describe
 */
public class HomeFragment extends BaseFragment<LoginPresenter> implements LoginContract.View {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


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
        mPresenter.login("liunian", MD5Helper.encrypt32WithKey("123456"), 0);
    }

    @Override
    public void getData(Object object) {

    }
}
