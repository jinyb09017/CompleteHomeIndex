package com.abbott.longhomeindex.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.base.CommonAdapter;
import com.abbott.longhomeindex.adapter.base.ViewHolder;
import com.abbott.longhomeindex.glide.ImagesUtil;
import com.abbott.longhomeindex.model.HomeBean;


/**
 * @author jyb jyb_96@sina.com on 2018/6/12.
 * @version V1.0
 * @Description: 热门路线
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HotLineAdapter extends CommonAdapter<HomeBean.AppTravelHotLineIndexDTOSBean> {
    public HotLineAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, HomeBean.AppTravelHotLineIndexDTOSBean appTravelHotLineIndexDTOSBean) {

        holder.setText(R.id.tv_line_name, appTravelHotLineIndexDTOSBean.getLineName());
        holder.setText(R.id.tv_sub_name, appTravelHotLineIndexDTOSBean.getSummary());
        holder.setText(R.id.tv_detail, appTravelHotLineIndexDTOSBean.getDetail());
        holder.setText(R.id.tv_price, appTravelHotLineIndexDTOSBean.getPrice() + "");

        ImageView iv_img = holder.getView(R.id.iv_img);
        ImagesUtil.loadRoundImage(appTravelHotLineIndexDTOSBean.getIndexUrl(), iv_img);


        if (holder.getmItemPosition() == 0) {
            holder.setVisible(R.id.tv_title, true);
        } else {
            holder.setVisible(R.id.tv_title, false);
        }


    }
}
