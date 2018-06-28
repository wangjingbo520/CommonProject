package com.xunz.commonproject.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * com.xunz.commonproject.base
 *
 * @author 王静波
 * @date 2018/6/11
 * describe
 */
public interface BaseContract {
    interface BasePresenter<T extends BaseContract.BaseView> {

        void attachView(T view);

        void detachView();
    }


    interface BaseView {

        /**
         * 显示进度中
         */

        void showLoading();

        /**
         * 显示请求成功
         */
        void showSuccess();

        /**
         * 没有数据的时候
         */
        void showEmptyView();
        /**
         * 失败重试
         */
        void showFaild();

        /**
         * 显示当前网络不可用
         */
        void showNoNet();

        /**
         * 重试
         */
        void onRetry();

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();

    }
}
