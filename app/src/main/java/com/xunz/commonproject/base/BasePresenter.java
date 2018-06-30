package com.xunz.commonproject.base;

import android.content.Context;

import com.xunz.commonproject.common.api.RequestClient;

/**
 * com.xunz.commonproject.base
 *
 * @author 王静波
 * @date 2018/6/11
 * describe
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract
        .BasePresenter<T> {

    protected T mView;
    protected Context mContext;
    public RequestClient requestClient;


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