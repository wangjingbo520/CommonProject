package com.xunz.commonproject.ui.fragment;


import android.os.Bundle;
import android.view.View;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.BaseFragment;
import com.xunz.commonproject.dagger2.component.ApplicationComponent;

/**
 * @author wangjingbo
 * @date 2018/6/27
 * describe
 */
public class UserFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_user;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onRetry() {
        super.onRetry();
        showLoading();
    }

    @Override
    public void initData() {
        showNoNet();
    }
}
