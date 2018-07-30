package com.xunz.commonproject.presenter;

import android.util.Log;

import com.xunz.commonproject.base.BasePresenter;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.common.utils.ToastUtil;
import com.xunz.commonproject.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * @author wangjingbo
 * @date 2018/6/30
 * describe
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements
        LoginContract.Presenter {
    RequestClient requestClient;

    @Inject
    public LoginPresenter(RequestClient requestClient) {
        this.requestClient = requestClient;
    }

    @Override
    public void login(String userName, String pwd) {
        requestClient.login(userName, pwd)
                .compose(mView.<User>bindToLife())
                .subscribe(new DisposableObserver<User>() {
                    @Override
                    public void onNext(User user) {
                        mView.onSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showFaild();
                        Log.e("--->", "onError: " + e.getMessage());
                        ToastUtil.showMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.showFaild();
                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                    }
                });


    }
}
