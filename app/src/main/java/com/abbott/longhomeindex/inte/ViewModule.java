package com.abbott.longhomeindex.inte;

import android.content.Context;
import android.view.View;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * <p>
 * 用于构建模块数据
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public interface ViewModule<T> {

    View createView(Context context);

    void fillData(T t);

}
