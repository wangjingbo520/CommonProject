package com.xunz.commonproject.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

/**
 * 作者: liangzixun
 * 时间: 2017/12/15 15:26
 * 邮箱: liangzixun@eims.com.cn
 */
public class DeviceUtils {
    /**
     * 获取二十位设备id 前四位为补充
     * @param context
     * @return
     */
    public static String getDeviceId(Context context){
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String id = androidID + Build.SERIAL;
        return "SNUM"+MD5Helper.encrypt16(id);
    }

    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
