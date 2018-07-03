package com.abbott.longhomeindex.utils;

import android.app.Application;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class AppContextUtil {

    public static Application app;

    public static void init(Application application) {
        app = application;
    }


    public static Application getAppContext() {
        return app;
    }
}
