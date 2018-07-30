package com.xunz.commonproject.contract;

import com.xunz.commonproject.base.BaseContract;
import com.xunz.commonproject.bean.User;

/**
 * @author wangjingbo
 * @date 2018/6/28
 * describe
 */
public interface RegisterContract {
    interface View extends BaseContract.BaseView {
        void getData(User user);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void postRegisterInfo(String code, String phone, String password);
    }


}
