package com.xunz.commonproject.contract;

import com.xunz.commonproject.base.BaseContract;

/**
 * @author Wangjingbo
 * @date 2018/7/30
 * describe 忘记密码
 */
public interface ForgetPassContract {
    interface View extends BaseContract.BaseView {
        void onSucessData(Object object);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void postData(String phone, String password);
    }
}
