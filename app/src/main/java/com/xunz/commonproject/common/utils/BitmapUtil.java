package com.xunz.commonproject.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者: liangzixun
 * 时间: 2017/12/6 17:03
 * 邮箱: liangzixun@eims.com.cn
 */
public class BitmapUtil {

    public static Bitmap showimageFull(String ImagePath, int w, int h) {
        Bitmap tempBitmap;
        int heightRatio = 0, widthRatio = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(ImagePath, options);
        heightRatio = (int) Math.ceil(options.outHeight / (float) h);
        widthRatio = (int) Math.ceil(options.outWidth / (float) w);

        if ((heightRatio > 1) && (widthRatio > 1)) {
            if (heightRatio > widthRatio) {
                options.inSampleSize = heightRatio;
            } else {
                options.inSampleSize = widthRatio;
            }
        }
        options.inJustDecodeBounds = false;
        tempBitmap = BitmapFactory.decodeFile(ImagePath, options);
        try {
            ExifInterface exif = new ExifInterface(ImagePath);
            String sModel = exif.getAttribute(ExifInterface.TAG_ORIENTATION);
            if (sModel.equals("6")) {
                Matrix matrix = new Matrix();
                matrix.setRotate(90);
                tempBitmap = Bitmap.createBitmap(tempBitmap, 0, 0, tempBitmap.getWidth(), tempBitmap.getHeight(), matrix, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempBitmap;
    }

    public static void saveBitmap(Bitmap bm, String file) {
        File f = new File(file);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
