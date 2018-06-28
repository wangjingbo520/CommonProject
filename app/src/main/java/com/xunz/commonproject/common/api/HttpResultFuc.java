package com.xunz.commonproject.common.api;

import io.reactivex.functions.Function;

public class HttpResultFuc<T> implements Function<HttpResult<T>, T> {
    @Override
    public T apply(HttpResult<T> tHttpResult) throws Exception {
        if (!"1".equals(tHttpResult.status)) {
            //非正常返回结构处理
            throw new ApiException(tHttpResult.status, tHttpResult.msg);
        }
        return tHttpResult.data;
    }
}
