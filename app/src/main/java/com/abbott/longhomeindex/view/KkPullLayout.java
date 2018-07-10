package com.abbott.longhomeindex.view;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * Created by zhangjianlin on 16-9-29.
 */
public class KkPullLayout extends PtrFrameLayout {

    private KKMRefreshHeader mKKRefreshHeader;

    public KkPullLayout(Context context) {
        super(context);
        initViews();
    }

    public KkPullLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public KkPullLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        mKKRefreshHeader = new KKMRefreshHeader(getContext());
        setHeaderView(mKKRefreshHeader);
        addPtrUIHandler(mKKRefreshHeader);
        disableWhenHorizontalMove(true);

    }

}
