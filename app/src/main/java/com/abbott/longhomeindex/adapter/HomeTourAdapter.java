package com.abbott.longhomeindex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.adapter.base.CommonAdapter;
import com.abbott.longhomeindex.adapter.base.ViewHolder;
import com.abbott.longhomeindex.glide.ImagesUtil;
import com.abbott.longhomeindex.model.HomeBean;
import com.abbott.longhomeindex.utils.ScreenUtil;


/**
 * @author jyb jyb_96@sina.com on 2018/6/12.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HomeTourAdapter extends CommonAdapter<HomeBean.AppTravelRecommendIndexDTOSBean> {
    public HomeTourAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, HomeBean.AppTravelRecommendIndexDTOSBean appTravelRecommendIndexDTOSBean) {

        ImageView iv_tour_pic = holder.getView(R.id.iv_tour_pic);
        ImagesUtil.loadRoundImage(appTravelRecommendIndexDTOSBean.getIndexUrl(), iv_tour_pic, R.drawable.default_image);


        View view = holder.getConvertView();
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (holder.getmItemPosition() == 0) {
            lp.leftMargin = ScreenUtil.dip2px(15);
        } else {
            lp.leftMargin = 0;
        }

        view.setLayoutParams(lp);

    }
}
