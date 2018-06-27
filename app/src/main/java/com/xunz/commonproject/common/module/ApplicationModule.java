//package com.xunz.commonproject.common.module;
//
//import android.content.Context;
//
//import com.xunz.commonproject.MyApplication;
//
//import dagger.Module;
//import dagger.Provides;
//
///**
// * desc:
// * author: Will .
// * date: 2017/9/2 .
// */
//@Module
//public class ApplicationModule {
//
//    private Context mContext;
//
//    public ApplicationModule(Context context) {
//        this.mContext = context;
//    }
//
//    @Provides
//    MyApplication provideApplication() {
//        return (MyApplication) mContext.getApplicationContext();
//    }
//
//    @Provides
//    Context provideContext() {
//        return mContext;
//    }
//}
