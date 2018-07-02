package com.xunz.commonproject.common.api;


import com.xunz.commonproject.bean.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * com.xunz.commonproject.net
 *
 * @author 王静波
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

    /**
     * 用户登录
     *
     * @param mobile     用户名
     * @param password   密码
     * @param is_company 个人企业标识 0个人用户 1企业用户 9放款人
     * @return
     */
    public Observable<User> login(String mobile, String password, int is_company) {
        return serverAPI.loginOPT101("101", mobile, password, is_company, 2)
                .map(new HttpResultFuc<User>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
