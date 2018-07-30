package com.xunz.commonproject.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.xunz.commonproject.AppData;
import com.xunz.commonproject.R;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.utils.DialogHelper;
import com.xunz.commonproject.view.MultiStateView;
import com.xunz.commonproject.view.SimpleMultiStateView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * com.xunz.commonproject.base
 *
 * @author 王静波
 * @date 2018/6/11
 * describe
 */
public abstract class BaseFragment<T1 extends BaseContract.BasePresenter> extends SupportFragment
        implements BaseContract.BaseView, IBase {

    protected Context mContext;
    protected View mRootView;
    protected Dialog mLoadingDialog = null;
    Unbinder unbinder;

    @Nullable
    @Inject
    protected T1 mPresenter;

    @BindView(R.id.SimpleMultiStateView)
    SimpleMultiStateView mSimpleMultiStateView;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachView();
        bindView(view, savedInstanceState);
        initStateView();
    }


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(getContentLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = createView(inflater, container, savedInstanceState);
        }

        mContext = mRootView.getContext();
        mLoadingDialog = DialogHelper.getLoadingDialog(getActivity());
        return mRootView;
    }

    /**
     * 同级下的 懒加载 ＋ ViewPager下的懒加载  的结合回调方法
     *
     * @param savedInstanceState
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initData();
    }

    private void initStateView() {
        if (mSimpleMultiStateView == null) {
            return;
        }
        mSimpleMultiStateView.setEmptyResource(R.layout.view_empty)
                .setRetryResource(R.layout.view_retry)
                .setLoadingResource(R.layout.view_loading)
                .setNoNetResource(R.layout.view_nonet)
                .build()
                .setonReLoadlistener(new MultiStateView.onReLoadlistener() {
                    @Override
                    public void onReload() {
                        onRetry();
                    }
                });
    }


    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showLoading() {
        if (mSimpleMultiStateView != null) {
            mSimpleMultiStateView.showLoadingView();
        }
    }

    @Override
    public void showSuccess() {
        hideLoadingDialog();
        if (mSimpleMultiStateView != null) {
            mSimpleMultiStateView.showContent();
        }
    }

    @Override
    public void showEmptyView() {
        if (mSimpleMultiStateView != null) {
            mSimpleMultiStateView.showEmptyView();
        }
    }

    protected void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void showFaild() {
        if (mSimpleMultiStateView != null) {
            mSimpleMultiStateView.showErrorView();
        }
    }

    @Override
    public void showNoNet() {
        if (mSimpleMultiStateView != null) {
            mSimpleMultiStateView.showNoNetView();
        }
    }

    @Override
    public void onRetry() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }


    public boolean userIsLogin(boolean startToLogin) {
        User user = AppData.getInstance().getUser();
        if(null == user){
            if(startToLogin){
//                startTo(LoginActivity.class);
            }
            return false;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public String getUserId() {
        return AppData.getInstance().getUserId();
    }
    public User getUser() {
        return AppData.getInstance().getUser();
    }

}
