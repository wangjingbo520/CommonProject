package com.xunz.commonproject.center.presenter;

import android.content.Context;

import com.xunz.commonproject.center.callback.IPhoneCodeCallback;
import com.xunz.commonproject.common.api.ProgressSubscriber;
import com.xunz.commonproject.common.base.BasePresenter;

/**
 * 手机验证码
 * Created by wangyun on 2018/1/6.
 */
public class PhoneCodePresenter extends BasePresenter {

    private IPhoneCodeCallback callback;

    public PhoneCodePresenter(Context context) {
        super(context);
    }

    public void setIFindPasswordView(IPhoneCodeCallback callback){
        this.callback = callback;
    }

    /**
     * 获取验证码
     * @param phone    手机号码
     * @param type     场景
     */
    public void getValidateCode(String phone, String type){

        mRequestClient.getValidateCode(phone,type).subscribe(new ProgressSubscriber<String>(mContext) {
            @Override
            public void onNext(String code) {
                if(null != callback){
                    callback.onGetPhoneCodeSuccess(code);
                }
            }
        });
    }
}
