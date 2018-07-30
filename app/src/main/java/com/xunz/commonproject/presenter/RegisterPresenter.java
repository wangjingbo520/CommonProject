package com.xunz.commonproject.presenter;

import com.xunz.commonproject.base.BasePresenter;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.contract.RegisterContract;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * com.xunz.commonproject.ui.presenter
 *
 * @author wangjingbo
 * @date 2018/6/28
 * describe
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements
        RegisterContract.Presenter {

    RequestClient requestClient;

    @Inject
    public RegisterPresenter(RequestClient requestClient) {
        this.requestClient = requestClient;
    }


    @Override
    public void postRegisterInfo(String code, String phone, String password) {
        requestClient.appRegister(code, phone, password)
                .compose(mView.<User>bindToLife())
                .subscribe(new DisposableObserver<User>() {
                    @Override
                    public void onNext(User user) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showFaild();

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                    }
                });
    }


}
