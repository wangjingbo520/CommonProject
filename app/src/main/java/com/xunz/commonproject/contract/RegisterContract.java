package com.xunz.commonproject.contract;

import com.xunz.commonproject.base.BaseContract;
import com.xunz.commonproject.bean.User;

/**
 * com.xunz.commonproject.ui.contract
 *
 * @author 王静波
 * @date 2018/6/28
 * describe
 */
public interface RegisterContract {
    interface View extends BaseContract.BaseView {
        /**
         * 注册成功回调
         *
         * @param user
         */
        void getData(User user);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        /**
         *   提交注册信息
         * @param phone
         * @param password
         * @param code
         */
        void postRegisterInfo(String code,String phone, String password);
    }


}
