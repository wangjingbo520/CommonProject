package com.xunz.commonproject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xunz.commonproject.dagger2.component.ApplicationComponent;


/**
 * com.xunz.commonproject.base
 *
 * @author 王静波
 * @date 2018/6/11
 * describe
 */
public interface IBase {
    /**
     * 创建视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 获取根布局
     *
     * @return
     */
    View getView();

    /**
     * 设置布局
     *
     * @return
     */
    int getContentLayout();

    /**
     * 初始化dogger,解耦
     *
     * @param appComponent
     */
    void initInjector(ApplicationComponent appComponent);

    /**
     * 绑定布局,获取id等
     *
     * @param view
     * @param savedInstanceState
     */
    void bindView(View view, Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    void initData();

}
