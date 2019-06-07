package com.feinno.commonlib.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Window;

import java.lang.reflect.Field;

public class DisplayUtils {
	/**
	 * 将px值转换为dp值
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dp值转换为px值
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * 获取屏幕宽度
	 */
	public static int getScreenWidthPixels(Activity context) {
		DisplayMetrics metric = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels;
	}

	/**
	 * 获取屏幕高度
	 */
	public static int getScreenHeightPixels(Activity context) {
		DisplayMetrics metric = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.heightPixels;
	}

	/**
	 * 获取屏幕密度字符串 hdpi xhdpi xxhdpi xxxhdpi
	 */
	public static String getDpi(Activity owner) {
		DisplayMetrics metric = new DisplayMetrics();
		if (owner==null){
			return "xxhdpi";
		}
		owner.getWindowManager().getDefaultDisplay().getMetrics(metric);
		int densityDpi = metric.densityDpi;
		if(densityDpi <= 240){
			return "hdpi";
		}else if(densityDpi <= 320){
			return "xhdpi";
		}else if(densityDpi <= 480){
			return "xxhdpi";
		}else{
			return "xxxhdpi";
		}
	}

	/**
	 * 获取屏幕宽度
	 * @param owner
	 * @return
	 */
	public static int getScreenWidth(Activity owner)
	{
		int width=owner.getWindowManager().getDefaultDisplay().getWidth();
		return width;
	}

	/**
	 * 获取屏幕宽度
	 * @param owner
	 * @return
	 */
	public static int getScreenHeight(Activity owner)
	{
		int height=owner.getWindowManager().getDefaultDisplay().getHeight();
		return height;
	}


	/**
	 * 获取状态栏高度
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context)
	{
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return statusBarHeight;
	}

	public static int getTitleBar(Activity ac)
	{
		int contentTop = ac.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
		Rect frame = new Rect();
		ac.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);

		int statusBarHeight=frame.top;
		int titleBarHeight = contentTop - statusBarHeight ;
		return  titleBarHeight;
	}


}
