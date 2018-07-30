package com.xunz.commonproject.contract;

import com.xunz.commonproject.base.BaseContract;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.presenter.LoginPresenter;

/**
 * com.xunz.commonproject.contract
 *
 * @author wangjingbo
 * @date 2018/6/30
 * describe
 */
public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void onSuccess(User user);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String userName, String pwd);
    }
}
