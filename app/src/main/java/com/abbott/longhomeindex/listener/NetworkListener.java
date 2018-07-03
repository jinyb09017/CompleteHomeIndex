package com.abbott.longhomeindex.listener;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public interface NetworkListener<T> {

    void success(T t);

    void error(Throwable throwable);

}
