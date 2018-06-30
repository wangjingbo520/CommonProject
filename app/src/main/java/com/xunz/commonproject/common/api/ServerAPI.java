package com.xunz.commonproject.common.api;


import com.xunz.commonproject.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * com.xunz.commonproject.net
 *
 * @author 王静波
 * @date 2018/6/28
 * describe
 */
public interface ServerAPI {

    /**
     * 用户注册
     *
     * @param code
     * @param password
     * @param phone
     * @return
     */
    @POST("user/appRegister.do")
    @FormUrlEncoded
    Observable<HttpResult<User>> appRegister(
            @Field("code") String code,
            @Field("password") String password,
            @Field("phone") String phone);


    /**
     * 登录
     *
     * @return
     */
    @POST("services")
    @FormUrlEncoded
    Observable<HttpResult<User>> loginOPT101(
            @Field("OPT") String OPT,
            @Field("mobile") String mobile,
            @Field("password") String password,
            @Field("is_company") int is_company,
            @Field("type") int type);


}
