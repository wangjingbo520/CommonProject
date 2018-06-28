package com.xunz.commonproject.common.api;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * com.xunz.commonproject.net
 *
 * @author 王静波
 * @date 2018/6/28
 * describe
 */
public abstract class MyObserver<T> implements Subscriber<T> {

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onSubscribe(Subscription s) {

    }
}
