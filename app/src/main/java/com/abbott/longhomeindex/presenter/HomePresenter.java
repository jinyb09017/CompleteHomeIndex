package com.abbott.longhomeindex.presenter;

import android.app.Activity;

import com.abbott.longhomeindex.inte.MainView;
import com.abbott.longhomeindex.listener.NetworkListener;
import com.abbott.longhomeindex.model.HomeBean;
import com.abbott.longhomeindex.model.NetworkRequest;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HomePresenter<V extends MainView> implements BasePresenter {
    V view;


    public HomePresenter(V view) {
        this.view = view;
    }

    @Override
    public void start() {

        NetworkRequest networkRequest = new NetworkRequest();
        view.showLoading();
        networkRequest.load(new NetworkListener<HomeBean>() {

            @Override
            public void success(final HomeBean homeBean) {

                //具体切换线程，可以根据项目情况来定。这里是做简化处理
                if (view instanceof Activity) {
                    ((Activity) view).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            view.show(homeBean);
                            view.dismissLoading();
                        }
                    });
                }

            }

            @Override
            public void error(Throwable throwable) {


                if (view instanceof Activity) {
                    ((Activity) view).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            view.showError();
                            view.dismissLoading();
                        }
                    });
                }


            }
        });

    }
}
