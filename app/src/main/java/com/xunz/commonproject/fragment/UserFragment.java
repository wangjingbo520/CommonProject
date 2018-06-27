package com.xunz.commonproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.BaseFragment;

/**
 * com.xunz.commonproject.fragment
 *
 * @author 王静波
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
