package com.abbott.longhomeindex;

import android.app.Application;

import com.abbott.longhomeindex.utils.AppContextUtil;
import com.abbott.longhomeindex.utils.ScreenUtil;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppContextUtil.init(this);
        ScreenUtil.GetInfo(this);
    }
}
