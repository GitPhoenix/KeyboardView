package com.github.phoenix.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 常用单位转换的辅助类
 *
 * @author Phoenix
 * @date 2016-8-3 14:58
 */
public class DensityUtil {

	private DensityUtil() {}

	/**
	 * dp转px
	 *
	 * @param context
	 * @param dpVal
	 * @return dip
	 */
	public static int dp2px(Context context, float dpVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * sp转px
	 *
	 * @param context
	 * @param spVal
	 * @return sp
	 */
	public static int sp2px(Context context, float spVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, spVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * px转dp
	 *
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2dp(Context context, float pxVal) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (pxVal / scale + 0.5f);
	}

	/**
	 * px转sp
	 *
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal) {
		final float scale = context.getResources().getDisplayMetrics().scaledDensity;
		return (pxVal / scale + 0.5f);
	}

}
