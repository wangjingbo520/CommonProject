package com.xunz.commonproject.common.module;

import dagger.Module;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
@Module
public class HttpModule {

//    @Provides
//    OkHttpClient.Builder provideOkHttpClient() {
//        // 指定缓存路径,缓存大小100Mb
//        Cache cache = new Cache(new File(MyApp.getContext().getCacheDir(), "HttpCache"),
//                1024 * 1024 * 100);
//        return new OkHttpClient().newBuilder().cache(cache)
//                .retryOnConnectionFailure(true)
//                .addInterceptor(RetrofitConfig.sLoggingInterceptor)
//                .addInterceptor(RetrofitConfig.sRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(RetrofitConfig.sRewriteCacheControlInterceptor)
//                .connectTimeout(10, TimeUnit.SECONDS);
//    }

//    @Provides
//    Retrofit.Builder provideBuilder(OkHttpClient okHttpClient) {
//        return new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttpClient);
//    }

//    @Provides
//    NewsApi provideNetEaseApis(OkHttpClient.Builder builder) {
//        builder.addInterceptor(RetrofitConfig.sQueryParameterInterceptor);
//
//        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(builder.build());
//
//        return NewsApi.getInstance(retrofitBuilder
//                .baseUrl(ApiConstants.sIFengApi)
//                .build().create(NewsApiService.class));
//    }
//
//    @Provides
//    JanDanApi provideJanDanApis(OkHttpClient.Builder builder) {
//
//        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(builder.build());
//
//        return JanDanApi.getInstance(retrofitBuilder
//                .baseUrl(ApiConstants.sJanDanApi)
//                .build().create(JanDanApiService.class));
//    }

}
