package com.abbott.longhomeindex.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.HomeLectureAdapter;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class LectureViewHolder implements ViewModule<HomeBean> {

    private RecyclerView rv_lecture;


    private HomeLectureAdapter homeLectureAdapter;


    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_lecture_holder, null);

        homeLectureAdapter = new HomeLectureAdapter(context, R.layout.item_lecture);


        rv_lecture = (RecyclerView) view.findViewById(R.id.rv_lecture);

        rv_lecture.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rv_lecture.setAdapter(homeLectureAdapter);


        return view;
    }

    @Override
    public void fillData(HomeBean homeBean) {


        if (homeBean.getAppTravelLectureIndexDTOS() != null && homeBean.getAppTravelLectureIndexDTOS().size() > 0) {
            homeLectureAdapter.clearTo(homeBean.getAppTravelLectureIndexDTOS());
        }


    }
}
