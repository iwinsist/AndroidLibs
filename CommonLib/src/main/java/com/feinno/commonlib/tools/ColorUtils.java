package com.feinno.commonlib.tools;

import android.graphics.Color;
import android.text.TextUtils;

/**
 * <pre>
 *     author : zhonghang
 *     e-mail : zhonghang@feinno.com
 *     time   : 2017/07/11 14:51
 *     desc   :用于颜色值的数值和字符串的转换
 *     version: 1.0
 * </pre>
 */


public class ColorUtils {
    /**
     * int值的color转换成字符串 例子 0xffffff转换成#ffffff
     *
     * @param color 传入的int值color
     * @return 返回String值的color
     */
    public static String colorInt2String(int color) {
        return String.format("#%06X", 0xFFFFFF &color);
    }
    /**
     * int值的color转换成字符串 例子 0xffffff转换成#ffffff
     *
     * @param color 传入的int值color
     * @return 返回String值的color
     */
    public static String colorInt2StringWithAlpha(int color) {
        return String.format("#%08X", 0xFFFFFFFF &color);
    }

    /**
     * String值的color的转换成int的色值 例子#ffffff转换成0xffffff
     *
     * @param color 字符串形式的色值
     * @return 数值型的颜色
     */
    public static int colorString2Int(String color) {
        if (TextUtils.isEmpty(color)) {
            return Color.argb(0XFF,0XB7,0XBD,0XCC);
        }
        return Color.parseColor(color);
    }
}
