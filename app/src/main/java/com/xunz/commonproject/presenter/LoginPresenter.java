package com.xunz.commonproject.presenter;

import com.xunz.commonproject.base.BasePresenter;
import com.xunz.commonproject.bean.User;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * com.xunz.commonproject.presenter
 *
 * @author 王静波
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
    public void login(String phone, String password, int is_company) {
        requestClient.login(phone, password, is_company)
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
