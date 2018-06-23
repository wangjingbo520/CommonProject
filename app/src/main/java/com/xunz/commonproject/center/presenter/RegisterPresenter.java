package com.xunz.commonproject.center.presenter;

import android.content.Context;

import com.xunz.commonproject.center.callback.IRegisterCallback;
import com.xunz.commonproject.common.api.ProgressSubscriber;
import com.xunz.commonproject.common.base.BasePresenter;

/**
 * 注册界面
 * Created by wangyun on 2017/12/29.
 */
public class RegisterPresenter extends BasePresenter {

    private IRegisterCallback callback;

    public RegisterPresenter(Context context) {
        super(context);
    }

    public void setIRegisterView(IRegisterCallback callback){
        this.callback = callback;
    }

    /**
     * 用户注册
     * @param code
     * @param password
     * @param phone
     */
    public void appRegister(String code, String password, String phone){
        mRequestClient.appRegister(code, password, phone).subscribe(new ProgressSubscriber<Object>(mContext) {
            @Override
            public void onNext(Object o) {
                if(null != callback){
                    callback.onRegisterSuccess();
                }
            }
        });
    }

}
