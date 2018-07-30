package com.xunz.commonproject.presenter;

import com.xunz.commonproject.base.BasePresenter;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.contract.ForgetPassContract;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * @author Wangjingbo
 * @date 2018/7/30
 * describe 忘记密码
 */
public class ForgetPasswordPresenter extends BasePresenter<ForgetPassContract.View> implements
        ForgetPassContract.Presenter {
    RequestClient requestClient;

    @Inject
    public ForgetPasswordPresenter(RequestClient requestClient) {
        this.requestClient = requestClient;
    }

    @Override
    public void postData(String phone, String password) {
//        requestClient.login(phone, password)
//                .compose(mView.<User>bindToLife())
//                .subscribe(new DisposableObserver<User>() {
//                    @Override
//                    public void onNext(User user) {
//                        mView.showSuccess();
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mView.showFaild();
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//
//                    @Override
//                    protected void onStart() {
//                        super.onStart();
//                    }
//                });

    }

//    @Override
//    public void login(String phone, String password, int is_company) {
//
//
//
//    }

}
