package com.abbott.longhomeindex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.abbott.longhomeindex.inte.MainView;
import com.abbott.longhomeindex.model.HomeBean;
import com.abbott.longhomeindex.module.BrokerViewHolder;
import com.abbott.longhomeindex.module.FooterViewHolder;
import com.abbott.longhomeindex.module.HeadViewHolder;
import com.abbott.longhomeindex.module.HotCityViewHolder;
import com.abbott.longhomeindex.module.HotLineHolder;
import com.abbott.longhomeindex.module.LectureViewHolder;
import com.abbott.longhomeindex.module.TourAndHotViewHolder;
import com.abbott.longhomeindex.presenter.HomePresenter;
import com.abbott.longhomeindex.utils.ScreenUtil;
import com.abbott.longhomeindex.utils.StatusBarUtil;
import com.abbott.longhomeindex.view.GradationScrollView;
import com.abbott.longhomeindex.view.KkPullLayout;
import com.abbott.longhomeindex.view.LongLinearLayout;
import com.abbott.longhomeindex.view.NetWorkLoading;
import com.abbott.longhomeindex.view.OverlayLayout;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class HomeTourActivity extends AppCompatActivity implements MainView<HomeBean> {

    private GradationScrollView scrollView;
    private LongLinearLayout longLinearLayout;
    private HomePresenter homePresenter;
    private int location;//记录滚动位置
    private RelativeLayout home_header_bar;
    private int changeTitleHeight = 100;
    private KkPullLayout mPtrFrame;
    private OverlayLayout overlayLayout;
    private NetWorkLoading networkLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tour);


        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        StatusBarUtil.setLightMode(HomeTourActivity.this);


        homePresenter = new HomePresenter(this);
        longLinearLayout = (LongLinearLayout) findViewById(R.id.long_linearLayout);
        scrollView = (GradationScrollView) findViewById(R.id.scrollView);
        home_header_bar = (RelativeLayout) findViewById(R.id.home_header_bar);
        mPtrFrame = (KkPullLayout) findViewById(R.id.mRefreshLayout);
        overlayLayout = new OverlayLayout(this);
        networkLoading = new NetWorkLoading(this);

        overlayLayout.setOverlayView(R.layout.holder_network);
        overlayLayout.attachTo(mPtrFrame);


        setListener();


        longLinearLayout.addViewModule(new HeadViewHolder());
        longLinearLayout.addViewModule(new TourAndHotViewHolder());
        longLinearLayout.addViewModule(new BrokerViewHolder());
        longLinearLayout.addViewModule(new HotCityViewHolder());
        longLinearLayout.addViewModule(new HotLineHolder());
        longLinearLayout.addViewModule(new LectureViewHolder());
        longLinearLayout.addViewModule(new FooterViewHolder());


        homePresenter.start(true);

        initRefreshLayout();
    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
// the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
// default is false
        mPtrFrame.setPullToRefresh(false);
// default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);


        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                homePresenter.start(false);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 10000);


    }


    private void setListener() {

        scrollView.setScrollViewListener(new GradationScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {

                location = y;

                refreshHeader();
            }
        });

        overlayLayout.findViewById(R.id.tv_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePresenter.start(true);
            }
        });
    }

    public void refreshHeader() {

        int y = location;
        if (y <= ScreenUtil.dip2px(changeTitleHeight) && y > ScreenUtil.dip2px(8)) {
            home_header_bar.setVisibility(View.VISIBLE);
            float alpha = (float) y / (float) ScreenUtil.dip2px(changeTitleHeight);
            Log.e("test", "alpha = " + alpha);
            home_header_bar.setAlpha(alpha);
            StatusBarUtil.setLightMode(this);


        } else if (y > ScreenUtil.dip2px(changeTitleHeight)) {
            home_header_bar.setAlpha(1);
            home_header_bar.setVisibility(View.VISIBLE);
            StatusBarUtil.setLightMode(this);


        } else {
            home_header_bar.setVisibility(View.GONE);
            StatusBarUtil.setDarkMode(this);
        }
    }


    @Override
    public void show(HomeBean homeBean) {

        longLinearLayout.buildUI();
        longLinearLayout.refreshData(homeBean);

        overlayLayout.hideOverlay();

    }

    @Override
    public void showLoading() {
        networkLoading.showDialog("");

    }

    @Override
    public void dismissLoading() {


        networkLoading.dismissDialog();
        mPtrFrame.refreshComplete();


    }


    @Override
    public void showError() {

        Log.e("jinyb", "随机出错了");
        overlayLayout.showOverlay();

    }

}
