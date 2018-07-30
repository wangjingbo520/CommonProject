package com.xunz.commonproject.bean;

import java.io.Serializable;

/**
 * 作者: liangzixun
 * 时间: 2017/10/27 10:53
 * 邮箱: liangzixun@eims.com.cn
 */
public class User implements Serializable {

    /**
     * expirationTime :
     * userId : 8
     * userName : 45678
     * openingTime :
     * mobile : 18219022852
     */

    private String expirationTime;
    private long userId;
    private String userName;
    private String openingTime;
    private long mobile;


    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

}
