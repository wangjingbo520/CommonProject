package com.xunz.commonproject.common.api;

import android.util.Log;

import com.xunz.commonproject.MyApplication;
import com.xunz.commonproject.common.sign.SecretConstains;
import com.xunz.commonproject.common.sign.SignCore;
import com.xunz.commonproject.common.utils.DeviceUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 拦截器－添加公用字段
 * 作者：liuyuanqi on 17/7/18 10:11
 * 邮箱：liuyuanqi@eims.com.cn
 */
//public class CommonInterceptor implements Interceptor {
//
//    private SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
//    /**
//     * 接口参数
//     * @param request
//     * @return
//     */
//    private Map<String, String> getParams(Request request){
//        Map<String, String> map = new HashMap<>();
//        if (request.body() instanceof FormBody) {
//            FormBody body = (FormBody) request.body();
//            for (int i = 0; i < body.size(); i++) {
//                map.put(body.encodedName(i), body.encodedValue(i));
//            }
//        }
//        return map;
//    }
//
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        // 添加新的参数
//        Request.Builder requestBuilder = request.newBuilder();
//        String method = request.method();
//        String qTime=format.format(System.currentTimeMillis());
//        Map<String, String> params=getParams(request);
//        params.put("deviceId", DeviceUtils.getDeviceId(MyApplication.context));
//        params.put("qTime",qTime);
//        params.put("appkey", SecretConstains.APP_KEY);
//        String sign= SignCore.getSignString(params);
//        if ("POST".equals(method)) {
//            FormBody.Builder formBodyBuilder = new FormBody.Builder();
//            formBodyBuilder.add("deviceId", DeviceUtils.getDeviceId(MyApplication.context));
// 此处添加deviceId参数
//            formBodyBuilder.add("appkey", SecretConstains.APP_KEY);//此处添加appkey参数
//            formBodyBuilder.add("qTime", qTime);//此处添加qTime参数
//            formBodyBuilder.add("sign", sign);//此处添加sign参数
//            RequestBody formBody = formBodyBuilder.build();
//            String postBodyString = bodyToString(request.body());
//            postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
//            requestBuilder.post(RequestBody.create(MediaType.parse
// ("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
//            String fullUrl = request.url()+"?"+postBodyString;
//            Log.d("RequestClient", "发送请求 "+fullUrl);
//        }
//        request=requestBuilder.build();
//        return chain.proceed(request);
//    }
//    private String bodyToString(final RequestBody request) {
//        try {
//            final RequestBody copy = request;
//            final Buffer buffer = new Buffer();
//            if (copy != null){
//                copy.writeTo(buffer);
//                return buffer.readUtf8();
//            } else{
//                return "";
//            }
//        } catch (final IOException e) {
//            return "did not work";
//        }
//    }
//}

public class CommonInterceptor implements Interceptor {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public Response intercept(Chain chain) throws IOException {
        //得到原始的请求对象
        Request request = chain.request();
        //得到用户所使用的请求方式
        String method = request.method();
        if ("GET".equals(method)) {
            HttpUrl.Builder builder = request.url().newBuilder();
            String qTime = format.format(System.currentTimeMillis());
            //加入公共参数
            builder.addQueryParameter("deviceId", DeviceUtils.getDeviceId(MyApplication.context));
            builder.addQueryParameter("qTime", qTime);
            builder.addQueryParameter("appkey", SecretConstains.APP_KEY);
            Map<String, String> params = getParamsGet(request);
            builder.addQueryParameter("sign", SignCore.getSignString(params));
            //重新构建请求体
            request = request.newBuilder().url(builder.build()).build();
            Log.d("RequestClient", request.url().toString());
        } else if ("POST".equals(method)) {
            String qTime = format.format(System.currentTimeMillis());
            Map<String, String> params = getParamsPost(request);
            //加入公共参数
            params.put("deviceId", DeviceUtils.getDeviceId(MyApplication.context));//
            params.put("qTime", qTime);
            params.put("appkey", SecretConstains.APP_KEY);
            Request.Builder builder = request.newBuilder();
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
            //加入公共参数sign
            formBodyBuilder.add("sign", SignCore.getSignString(params));
            //重新构建请求体
            request = builder.post(formBodyBuilder.build()).build();
            String postBodyString = bodyToString(request.body());
            String fullUrl = request.url() + "?" + postBodyString;
            Log.d("RequestClient", fullUrl);
        }
        //重新发送请求
        return chain.proceed(request);

    }


    private Map<String, String> getParamsPost(Request request) {
        Map<String, String> map = new HashMap<>();
        if (request.body() instanceof FormBody) {
            FormBody body = (FormBody) request.body();
            for (int i = 0; i < body.size(); i++) {
//                map.put(body.encodedName(i), body.encodedValue(i));
                map.put(body.name(i), body.value(i));
            }
        }
        return map;
    }

    private Map<String, String> getParamsGet(Request request) {
        Map<String, String> map = new HashMap<>();
        HttpUrl httpUrl = request.url();
        for (int i = 0; i < httpUrl.querySize(); i++) {
            map.put(httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i));
        }
        return map;
    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null) {
                copy.writeTo(buffer);
                return buffer.readUtf8();
            } else {
                return "";
            }
        } catch (final IOException e) {
            return "did not work";
        }
    }
}

