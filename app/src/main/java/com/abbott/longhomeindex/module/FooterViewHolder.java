package com.abbott.longhomeindex.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.inte.ViewModule;
import com.abbott.longhomeindex.model.HomeBean;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class FooterViewHolder implements ViewModule<HomeBean> {



    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_footer, null);
        return view;
    }

    @Override
    public void fillData(HomeBean homeBean) {




    }
}
