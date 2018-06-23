package com.xunz.commonproject.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xunz.commonproject.R;
import com.xunz.commonproject.base.MyBaseActivity;

import butterknife.BindView;

public class TestActivity1 extends MyBaseActivity {


    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;

    @Override
    public void onRetry() {
        showSuccess();

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test1;
    }



    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        setTitle("首页");

    }

    @Override
    public void initData() {

    }


}
