package com.github.phoenix.base;

import android.app.Application;
import android.content.Context;

/**
 * 此类中只做初始化，不要放入逻辑代码
 *
 * @author Phoenix
 * @date 2016-11-21 9:28
 */
public class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    /**
     * 获取上下文
     * @return Context
     */
    public static Context getContext() {
        return context;
    }
}
