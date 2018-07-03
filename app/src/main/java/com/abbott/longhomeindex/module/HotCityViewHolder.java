package com.abbott.longhomeindex.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.HotCityAdapter;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HotCityViewHolder implements ViewModule<HomeBean> {

    private RecyclerView rv_hot_city;


    private HotCityAdapter hotCityAdapter;


    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hot_city_holder, null);

        hotCityAdapter = new HotCityAdapter(context, R.layout.item_hot_city);


        rv_hot_city = (RecyclerView) view.findViewById(R.id.rv_hot_city);

        rv_hot_city.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rv_hot_city.setAdapter(hotCityAdapter);


        return view;
    }

    @Override
    public void fillData(HomeBean homeBean) {


        if (homeBean.getAppTravelHotCityIndexDTOS() != null && homeBean.getAppTravelHotCityIndexDTOS().size() > 0) {
            hotCityAdapter.clearTo(homeBean.getAppTravelHotCityIndexDTOS());
        }


    }
}
