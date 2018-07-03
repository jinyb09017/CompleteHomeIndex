package com.abbott.longhomeindex.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.HomeBrokerAdapter;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class BrokerViewHolder implements ViewModule<HomeBean> {

    RecyclerView recyclerView;
    HomeBrokerAdapter homeBrokerAdapter;

    @Override
    public View createView(Context context) {
        recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        homeBrokerAdapter = new HomeBrokerAdapter(context, R.layout.item_broker);
        recyclerView.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.setAdapter(homeBrokerAdapter);
        return recyclerView;
    }

    @Override
    public void fillData(HomeBean homeBean) {

        if (homeBean.getAppTravelBrokerIndexDTOS() != null && homeBean.getAppTravelBrokerIndexDTOS().size() > 0) {
            homeBrokerAdapter.clearTo(homeBean.getAppTravelBrokerIndexDTOS());
        }

    }
}
