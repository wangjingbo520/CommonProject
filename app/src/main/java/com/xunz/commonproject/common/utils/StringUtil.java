package com.xunz.commonproject.common.utils;

/**
 * 作者: liangzixun
 * 时间: 2017/9/8 11:38
 * 邮箱: liangzixun@eims.com.cn
 */
public class StringUtil {
    public static boolean isEmpty(String data){
        if (data==null||"".equals(data)){
            return true;
        }
        return false;
    }
}
