package com.dqc.weatherforecast.presentation.utils;

import android.content.Context;
import android.util.TypedValue;

public class StatusBarUtil {

    /**
     * 获取状态栏的高度
     * @param context 上下文
     * @return 状态栏高度（以像素为单位）
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 将 dp 转换为像素
     * @param context 上下文
     * @param dp dp 值
     * @return 像素值
     */
    public static int dpToPx(Context context, int dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()));
    }

    /**
     * 将像素转换为 dp
     * @param context 上下文
     * @param px 像素值
     * @return dp 值
     */
    public static int pxToDp(Context context, int px) {
        return Math.round(px / context.getResources().getDisplayMetrics().density);
    }
}

