package com.abbott.longhomeindex.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.abbott.longhomeindex.inte.ViewModule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class LongLinearLayout<T, R extends ViewModule> extends LinearLayout {

    public boolean hasBuild;//是否已经构建ui

    List<R> allView = new ArrayList<>();

    public LongLinearLayout(Context context) {
        super(context);
    }

    public LongLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LongLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 添加view模块
     *
     * @param inter
     */
    public void addViewModule(R inter) {
        if (inter != null) {
            allView.add(inter);
        }
    }


    /**
     * 删除模块
     *
     * @param inter
     * @return
     */
    public boolean removeViewModule(R inter) {
        if (inter != null) {
            if (allView.contains(inter)) {
                return allView.remove(inter);
            }
        }

        return false;
    }


    /**
     * 构建ui
     */
    public void buildUI() {

        if (hasBuild) return;
        for (R r : allView) {
            View view = r.createView(getContext());
            addView(view);
        }

        hasBuild = true;
    }


    /**
     * 刷新数据
     *
     * @param t
     */
    public void refreshData(T t) {

        if (t == null) return;

        for (R r : allView) {
            r.fillData(t);
        }


    }
}
