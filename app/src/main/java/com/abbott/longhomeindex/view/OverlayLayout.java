package com.abbott.longhomeindex.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.abbott.longhomeindex.utils.ViewUtil;

/**
 *
 * @description：覆盖页面
 * @author lihy @date 2014年11月10日 上午9:34:25
 * @author fanxing 修改于 Dec 2, 2014
 */
public class OverlayLayout extends RelativeLayout {

    protected View mOverlay;
    protected View mTargetView;
    protected boolean mIsHideTargetViewWhenOverlayShown = true;

    public OverlayLayout(Context context) {
        super(context);
    }

    public OverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OverlayLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置目标view
     *
     * @param targetView
     * @return
     */
    public void attachTo(final View targetView) {
        if (targetView == null) {
            throw new IllegalArgumentException();
        }
        mTargetView = targetView;

        ViewGroup.LayoutParams layoutParams = mTargetView.getLayoutParams();
        this.setLayoutParams(layoutParams);

        if (mTargetView.getParent() != null && mTargetView.getParent() instanceof ViewGroup) {
            addTargetView();
        } else {
            ViewUtil.addGlobalLayoutListenerOnce(mTargetView, new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (mTargetView.getParent() != null && mTargetView.getParent() instanceof ViewGroup) {
                        addTargetView();
                    }
                }
            });
        }
    }

    private void addTargetView() {
        ViewGroup targetViewParent = (ViewGroup) mTargetView.getParent();
        int targetViewPosInParent = targetViewParent.indexOfChild(mTargetView);
        targetViewParent.removeView(mTargetView);
        targetViewParent.addView(this, targetViewPosInParent, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams targetParams = new ViewGroup.LayoutParams(-1, -1);
        this.addView(mTargetView, targetParams);
    }

    /**
     * 显示覆盖view
     *
     * @author FAN 注释于Dec 2, 2014
     */
    public void showOverlay() {
        if (mOverlay != null) {
            mOverlay.setVisibility(VISIBLE);
        }
        if (mIsHideTargetViewWhenOverlayShown && mTargetView != null) {
            mTargetView.setVisibility(GONE);
        }
    }

    /**
     * 隐藏覆盖view
     *
     * @author FAN 注释于Dec 2, 2014
     */
    public void hideOverlay() {
        if (mOverlay != null) {
            mOverlay.setVisibility(GONE);
        }
        if (mIsHideTargetViewWhenOverlayShown && mTargetView != null) {
            mTargetView.setVisibility(VISIBLE);
        }
    }

    /**
     * 设置是否一次只显示目标view和覆盖view中的一个
     *
     * @param isHideTargetViewWhenOverlayShown
     * @author FAN 创建于Dec 2, 2014
     */
    public void setIsHideTargetViewWhenOverlayShown(boolean isHideTargetViewWhenOverlayShown) {
        mIsHideTargetViewWhenOverlayShown = isHideTargetViewWhenOverlayShown;
    }

    public boolean isOverlayShown() {
        return mOverlay != null && mOverlay.getVisibility() == VISIBLE;
    }

    public View getOverlayView() {
        return mOverlay;
    }

    /**
     * 设置覆盖显示用的布局
     *
     * @return
     */
    public void setOverlayView(View overLay) {
        setOverlayView(overLay, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 设置覆盖显示用的布局　可以设置高度的
     *
     * @return
     */
    public void setOverlayView(View overLay, int w, int h) {
        this.mOverlay = overLay;
        addView(mOverlay, new ViewGroup.LayoutParams(w, h));
    }

    /**
     * 返回overLayId  inflater出来的对应view
     */
    public View setOverlayView(int overLayId) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View overlay = inflater.inflate(overLayId, this, false);
        setOverlayView(overlay);
        return overlay;
    }
}