package com.abbott.longhomeindex.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.HomeHotAdapter;
import com.abbott.longhomeindex.adapter.HomeTourAdapter;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class TourAndHotViewHolder implements ViewModule<HomeBean> {

    private RecyclerView rv_rent;
    private RecyclerView rv_tour;

    private HomeHotAdapter homeHotAdapter;
    private HomeTourAdapter homeTourAdapter;


    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tour_hot_holder, null);

        homeHotAdapter = new HomeHotAdapter(context, R.layout.item_hot);
        homeTourAdapter = new HomeTourAdapter(context, R.layout.item_tour);

        rv_rent = (RecyclerView) view.findViewById(R.id.rv_rent);
        rv_rent.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rv_rent.setAdapter(homeHotAdapter);

        rv_tour = (RecyclerView) view.findViewById(R.id.rv_tour);
        rv_tour.setAdapter(homeTourAdapter);
        rv_tour.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    @Override
    public void fillData(HomeBean homeBean) {


        if (homeBean.getAppTravelRecommendIndexDTOS() != null && homeBean.getAppTravelRecommendIndexDTOS().size() > 0) {
            homeTourAdapter.clearTo(homeBean.getAppTravelRecommendIndexDTOS());
        }
        if (homeBean.getAppTravelHotTowIndexDTOS() != null && homeBean.getAppTravelHotTowIndexDTOS().size() > 0) {
            homeHotAdapter.clearTo(homeBean.getAppTravelHotTowIndexDTOS());
        }


    }
}
