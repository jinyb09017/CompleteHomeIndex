package com.abbott.longhomeindex.model;

import android.util.Log;

import com.abbott.longhomeindex.listener.NetworkListener;
import com.abbott.longhomeindex.utils.AppContextUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Random;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class NetworkRequest implements LoadModule, Runnable {

    NetworkListener networkListener;

    @Override
    public void load(NetworkListener networkListener) {

        this.networkListener = networkListener;


        Thread thread = new Thread(this);
        thread.start();


    }


    @Override
    public void run() {

        Log.e("jinyb", "模拟请求网络数据开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int num = random.nextInt(10);

        if (networkListener != null) {
            if (num > 8) {
                networkListener.error(new SocketException("这是模拟的网络异常"));
            } else {
                networkListener.success(toBean(readStr()));
            }


        }


        Log.e("jinyb", "模拟请求网络数据结束");
    }

    public String readStr() {

        InputStream inputStream = null;
        try {
            inputStream = AppContextUtil.getAppContext().getAssets().open("data.json");
            int size = inputStream.available();

            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            inputStream.close();
            String str = new String(bytes);

            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    public HomeBean toBean(String json) {
        Gson gson = new Gson();
        KResponseResult<HomeBean> kResponseResult = gson.fromJson(json, new TypeToken<KResponseResult<HomeBean>>() {
        }.getType());

        return kResponseResult.getData();
    }

}
