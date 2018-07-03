package com.abbott.longhomeindex.inte;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: 定义接口行为
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public interface MainView<R> {

    void show(R r);

    void showLoading();

    void dismissLoading();

    void showError();


}
