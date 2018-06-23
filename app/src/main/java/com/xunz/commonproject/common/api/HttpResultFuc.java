package com.xunz.commonproject.common.api;

import rx.functions.Func1;

public class HttpResultFuc<T> implements Func1<HttpResult<T>,T> {
    @Override
    public T call(HttpResult<T> httpResult) {
        if(!"1".equals(httpResult.status)){

            //非正常返回结构处理
            throw new ApiException(httpResult.status, httpResult.msg);
        }
        return httpResult.data;
    }
}
