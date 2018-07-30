package com.xunz.commonproject.base;

/**
 *
 * @author wangjingbo
 * @date 2018/6/11
 * describe
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract
        .BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}