package com.xunz.commonproject.dagger2.module;

import com.xunz.commonproject.MyApplication;
import com.xunz.commonproject.common.api.CommonInterceptor;
import com.xunz.commonproject.common.api.LoggingInterceptor;
import com.xunz.commonproject.common.api.RequestClient;
import com.xunz.commonproject.common.api.ServerAPI;
import com.xunz.commonproject.common.api.URLs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClient() {
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(MyApplication.getInstance().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        return new OkHttpClient().newBuilder().cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(new CommonInterceptor())
                .addNetworkInterceptor(new LoggingInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    Retrofit.Builder provideBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);
    }

    @Provides
    RequestClient provideNetEaseApis(OkHttpClient.Builder builder) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build());

        return RequestClient.getInstance(retrofitBuilder
                .baseUrl(URLs.SERVERURL)
                .build().create(ServerAPI.class));
    }


}
