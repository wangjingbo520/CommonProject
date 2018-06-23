package com.xunz.commonproject.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xunz.commonproject.AppData;
import com.xunz.commonproject.base.SupportActivity;
import com.xunz.commonproject.center.model.User;

/**
 * 作者: liangzixun
 * 时间: 2017/9/5 16:28
 * 邮箱: liangzixun@eims.com.cn
 */
public class BaseActivity extends SupportActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void startTo(Class c){
        startActivity(new Intent(this, c));
    }

    public String getUserId() {
        return AppData.getInstance().getUserId();
    }

    public boolean userIsLogin(boolean startToLogin) {
        User user = AppData.getInstance().getUser();
        if(null == user){
            if(startToLogin){
//                startTo(LoginActivity.class);
            }
            return false;
        }
        return true;
    }


    public User getUser() {
        return AppData.getInstance().getUser();
    }
}
