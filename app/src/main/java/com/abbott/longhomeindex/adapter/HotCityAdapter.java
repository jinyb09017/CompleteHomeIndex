package com.abbott.longhomeindex.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.base.CommonAdapter;
import com.abbott.longhomeindex.adapter.base.ViewHolder;
import com.abbott.longhomeindex.glide.ImagesUtil;
import com.abbott.longhomeindex.model.HomeBean;


/**
 * @author jyb jyb_96@sina.com on 2018/6/12.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HotCityAdapter extends CommonAdapter<HomeBean.AppTravelHotCityIndexDTOSBean> {
    public HotCityAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, HomeBean.AppTravelHotCityIndexDTOSBean appTravelHotCityIndexDTOSBean) {

        ImageView iv_hot_first = holder.getView(R.id.iv_hot_first);

        if (appTravelHotCityIndexDTOSBean.getSubList() != null && appTravelHotCityIndexDTOSBean.getSubList().size() > 0) {
            ImagesUtil.loadRoundImage(appTravelHotCityIndexDTOSBean.getSubList().get(0).getIndexUrl(), iv_hot_first);
            holder.setText(R.id.tv_hot_first_keywords, appTravelHotCityIndexDTOSBean.getSubList().get(0).getKeywords());
            holder.setVisible(R.id.rv_bg, true);
        } else {

            holder.setVisible(R.id.rv_bg, false);
            holder.setVisible(R.id.iv_hot_first, false);
        }

        holder.setText(R.id.tv_city, appTravelHotCityIndexDTOSBean.getCityName());
        holder.setText(R.id.tv_summary, appTravelHotCityIndexDTOSBean.getSummary());
        holder.setText(R.id.tv_detail, appTravelHotCityIndexDTOSBean.getDetail());


        RecyclerView rv_sub_hot = holder.getView(R.id.rv_sub_hot);

        HotCitySubAdapter hotCitySubAdapter = new HotCitySubAdapter(mContext, R.layout.item_hot_city_item);
        rv_sub_hot.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rv_sub_hot.setAdapter(hotCitySubAdapter);

        if (appTravelHotCityIndexDTOSBean.getSubList() != null && appTravelHotCityIndexDTOSBean.getSubList().size() > 0) {
            hotCitySubAdapter.clearTo(appTravelHotCityIndexDTOSBean.getSubList().subList(1, appTravelHotCityIndexDTOSBean.getSubList().size()));
        }


    }
}
