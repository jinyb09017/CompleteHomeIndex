package com.abbott.longhomeindex.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.utils.ScreenUtil;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;


/**
 * add by jinyb
 */
public class KKMRefreshHeader extends ViewGroup implements PtrUIHandler {

    private float lastDegree;
    ValueAnimator valueAnimator;

    public KKMRefreshHeader(Context context) {
        super(context);
        initViews();
    }

    public KKMRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public KKMRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtil.screenWidth, ScreenUtil.dip2px(65));
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int viewCount = getChildCount();
//        Log.e("haha", "view num = " + viewCount);
//        Log.e("haha", "getWidth = " + getWidth());

        for (int i = 0; i < viewCount; i++) {
            View view = getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();

//            Log.e("haha", "width " + i + "= " + width);
//            Log.e("haha", "height " + i + "= " + height);

            //所有的view居中显示
            view.layout(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, getWidth() / 2 + width / 2, getHeight() / 2 + height / 2);
        }
    }

    protected void initViews() {
        valueAnimator = ValueAnimator.ofFloat(0, 180, 360);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rotate((Float) animation.getAnimatedValue());
            }
        });


        ImageView center = new ImageView(getContext());
        center.setImageResource(R.drawable.base_ico_refresh_center);
        center.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        addView(center);

        ImageView refresh = new ImageView(getContext());
        refresh.setImageResource(R.drawable.base_ico_progress_refresh);
        refresh.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(refresh);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {
        Log.d("KKRefreshHeader", "onUIReset");
        if (valueAnimator != null) {
            valueAnimator.end();
        }


    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        Log.d("KKRefreshHeader", "onUIRefreshPrepare");

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        Log.d("KKRefreshHeader", "onUIRefreshBegin");
        if (valueAnimator != null) {
            valueAnimator.start();
        }


    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        Log.d("KKRefreshHeader", "onUIRefreshComplete");
        if (valueAnimator != null) {
            valueAnimator.end();
        }

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        Log.d("KKRefreshHeader", "onUIPositionChange=" + ptrIndicator.getCurrentPercent());
        Log.d("KKRefreshHeader", "onUIPositionChange y=" + ptrIndicator.getOffsetY());

        lastDegree = ptrIndicator.getCurrentPercent() * 360;
        rotate(lastDegree);
    }

    public void rotate(float degree) {
        getChildAt(getChildCount() - 1).setRotation(degree);
    }


}
