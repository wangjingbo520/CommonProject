package com.xunz.commonproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.xunz.commonproject.base.BaseActivity;
import com.xunz.commonproject.test.TestActivity1;


/**
 * 作者: liangzixun
 * 时间: 2017/10/27 09:23
 * 邮箱: liangzixun@eims.com.cn
 */
public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        initData();
    }

    private void initData() {
        handler.sendEmptyMessageDelayed(100, 2000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    startTo(TestActivity1.class);
                    finish();
                    break;
            }
        }
    };
}
