package com.xunz.commonproject.common.api;


import com.xunz.commonproject.bean.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * @author wangjingbo
 * @date 2018/6/28
 * describe
 */
public class RequestClient {
    public static RequestClient sInstance;
    private ServerAPI serverAPI;

    public RequestClient(ServerAPI serverAPI) {
        this.serverAPI = serverAPI;
    }

    public static RequestClient getInstance(ServerAPI serverAPI1) {
        if (sInstance == null) {
            sInstance = new RequestClient(serverAPI1);
        }
        return sInstance;
    }

    public Observable<User> appRegister(String code, String password, String phone) {
        return serverAPI.appRegister(code, password, phone)
                .map((new HttpResultFuc<User>()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<User> login(String userName, String pwd) {
        return serverAPI.login(userName,pwd)
                .map(new HttpResultFuc<User>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



}
