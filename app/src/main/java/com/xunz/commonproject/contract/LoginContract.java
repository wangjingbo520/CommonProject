package com.xunz.commonproject.contract;

import com.xunz.commonproject.base.BaseContract;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.presenter.LoginPresenter;

/**
 * com.xunz.commonproject.contract
 *
 * @author 王静波
 * @date 2018/6/30
 * describe
 */
public interface LoginContract {
    interface View extends BaseContract.BaseView {
        /**
         * 登录
         *
         * @param
         */
        void getData(Object object);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        /**
         * 提交注册信息
         *
         * @param phone
         * @param password
         */
        void login(String phone, String password, int is_company);
    }
}
