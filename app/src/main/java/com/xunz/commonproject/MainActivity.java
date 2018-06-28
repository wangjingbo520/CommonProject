package com.xunz.commonproject;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.xunz.commonproject.base.BaseActivity;
import com.xunz.commonproject.common.utils.StatusBarUtil;
import com.xunz.commonproject.ui.fragment.HomeFragment;
import com.xunz.commonproject.ui.fragment.UserFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * com.xunz.commonproject
 *
 * @author 王静波
 * @date 2018/6/27
 * describe
 */
public class MainActivity extends BaseActivity {
    private HomeFragment homeFragment;
    private UserFragment userFragment;

    private long firstPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.themeColor), 0);
        ButterKnife.bind(this);
        initFragment(0);
    }


    private void initFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance("", "");
                    transaction.add(R.id.main_frame, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (userFragment == null) {
                    userFragment = UserFragment.newInstance("", "");
                    transaction.add(R.id.main_frame, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    @OnClick({R.id.tab_home, R.id.tab_rongtong, R.id.tab_user, R.id.tab_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_home:
                initFragment(0);
                break;
            case R.id.tab_rongtong:
                initFragment(0);
                break;
            case R.id.tab_user:
                initFragment(0);
                break;
            case R.id.tab_more:
                initFragment(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        if (System.currentTimeMillis() - firstPressedTime < 2000) {
            super.onBackPressed();
        } else {
            showToast("再按一次退出");
            firstPressedTime = System.currentTimeMillis();
        }
    }

}
