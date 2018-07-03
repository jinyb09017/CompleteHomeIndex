package com.abbott.longhomeindex.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;
import com.abbott.longhomeindex.utils.ScreenUtil;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HeadViewHolder implements ViewModule<HomeBean> {

    ImageView iv;


    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_header, null);
        iv = (ImageView) view.findViewById(R.id.iv_bg);
        return view;
    }

    @Override
    public void fillData(HomeBean homeBean) {


        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv.getLayoutParams();
        lp.height = (int) (ScreenUtil.getDisplayWidth() * (float) 342 / (float) 375);

        iv.setLayoutParams(lp);


    }
}
