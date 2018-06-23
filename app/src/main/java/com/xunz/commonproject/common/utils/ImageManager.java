package com.xunz.commonproject.common.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xunz.commonproject.MyApplication;
import com.xunz.commonproject.R;

/**
 * 图片获取统一管理类
 */
public class ImageManager {

    /**
     * 默认图片
     */
    public static int IMAGE_DEFAULT = R.mipmap.ic_launcher;


    /**
     * 加载图片
     *
     * @param imgUrl
     * @param imageView
     */
    public static void Load(String imgUrl, ImageView imageView) {
        Glide.with(MyApplication.context).load(imgUrl).error(IMAGE_DEFAULT).into(imageView);
    }

}
