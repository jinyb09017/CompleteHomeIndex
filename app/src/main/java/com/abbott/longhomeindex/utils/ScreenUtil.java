package com.abbott.longhomeindex.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2015/6/18.
 */
public class ScreenUtil {

    public static int screenWidth;
    public static int screenHeight;
    public static int screenMin;// 宽高中，较小的值
    public static int screenMax;// 宽高中，较大的值

    public static float density;
    public static float scaleDensity;
    public static float xdpi;
    public static float ydpi;
    public static int densityDpi;
    public static int statusbarheight;
    public static int navbarheight;

    public static void GetInfo(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        screenMax = (screenWidth < screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
        statusbarheight = getStatusBarHeight(context);
        navbarheight = getNavBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = context.getResources().getDimensionPixelSize(x);
        } catch (Exception E) {
            E.printStackTrace();
        }
        return sbar;
    }

    public static int getNavBarHeight(Context context){
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public static int dip2px(float dipValue) {
        final float scale = ScreenUtil.getDisplayDensity();
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(float pxValue) {
        final float scale = ScreenUtil.getDisplayDensity();
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp( float pxValue) {
        final float fontScale = scaleDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(float spValue) {
        final float fontScale = scaleDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static float getDisplayDensity() {
        if(density == 0){
            GetInfo(AppContextUtil.getAppContext());
        }
        return density;
    }

    public static int getDisplayWidth(){
        if(screenWidth == 0){
            GetInfo(AppContextUtil.getAppContext());
        }
        return screenWidth;
    }

    public static int getDisplayHeight() {
        if(screenHeight == 0){
            GetInfo(AppContextUtil.getAppContext());
        }
        return screenHeight;
    }

    public static int getScreenMin() {
        if(screenMin == 0){
            GetInfo(AppContextUtil.getAppContext());
        }
        return screenMin;
    }

    public static int getScreenMax() {
        if(screenMin == 0){
            GetInfo(AppContextUtil.getAppContext());
        }
        return screenMax;
    }

    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
