package com.abbott.longhomeindex.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

public class HomeBrokerAdapter extends CommonAdapter<HomeBean.AppTravelBrokerIndexDTOSBean> {
    public HomeBrokerAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, HomeBean.AppTravelBrokerIndexDTOSBean appTravelBrokerIndexDTOSBean) {

        ImageView iv_profile = holder.getView(R.id.iv_profile);
        ImagesUtil.loadCircleImage(appTravelBrokerIndexDTOSBean.getAvatarUrl(), iv_profile, R.drawable.default_image);


        View v = holder.getView(R.id.v_line);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v.getLayoutParams();

        if (holder.getmItemPosition() == getItemCount() - 1) {

            lp.leftMargin = ScreenUtil.dip2px(0);
        } else {
            lp.leftMargin = ScreenUtil.dip2px(42);
        }

        v.setLayoutParams(lp);


        holder.setText(R.id.tv_broker_title, appTravelBrokerIndexDTOSBean.getBrokerTitle());
        holder.setText(R.id.tv_short_title, appTravelBrokerIndexDTOSBean.getShortTitle());


    }
}
