package com.xunz.commonproject.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;
import com.xunz.commonproject.common.component.ApplicationComponent;
import com.xunz.commonproject.view.MultiStateView;
import com.xunz.commonproject.view.SimpleMultiStateView;

public class TestActivity2 extends AppCompatActivity {

    private SimpleMultiStateView mSimpleMultiStateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        bindView();
        initStateView();
    }

    private void bindView() {
        mSimpleMultiStateView = findViewById(R.id.SimpleMultiStateView);
    }


    private void initStateView() {
        if (mSimpleMultiStateView == null) {
            return;
        }
        mSimpleMultiStateView.setEmptyResource(R.layout.view_empty)
                .setRetryResource(R.layout.view_retry)
                .setLoadingResource(R.layout.view_loading)
                .setNoNetResource(R.layout.view_nonet)
                .build()
                .setonReLoadlistener(new MultiStateView.onReLoadlistener() {
                    @Override
                    public void onReload() {
                    }
                });

        mSimpleMultiStateView.showLoadingView();

    }

    //    @Override
//    public void onRetry() {
//
//    }
//
//    @Override
//    public int getContentLayout() {
//        return R.layout.activity_test2;
//    }
//
//    @Override
//    public void initInjector(ApplicationComponent appComponent) {
//
//    }
//
//    @Override
//    public void bindView(View view, Bundle savedInstanceState) {
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
}
