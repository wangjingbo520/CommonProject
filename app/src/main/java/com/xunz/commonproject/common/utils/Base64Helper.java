package com.xunz.commonproject.common.utils;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by liangzixun on 2018/3/14.
 */

public class Base64Helper {

    public static String encode(Object object) {
        String base64 = "";
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            base64 = Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
            outputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }

    public static Object decode(String base64) {
        Object object = "";
        try {
            byte[] objBytes = Base64.decode(base64.getBytes(), Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            // 将byte数组转换成product对象
            object = ois.readObject();
            bais.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
