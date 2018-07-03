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
import com.abbott.longhomeindex.view.LongLinearLayout;
import com.abbott.longhomeindex.view.NetWorkLoading;
import com.abbott.longhomeindex.view.OverlayLayout;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class MainActivity extends AppCompatActivity implements MainView<HomeBean>, BGARefreshLayout.BGARefreshLayoutDelegate {

    private GradationScrollView scrollView;
    private LongLinearLayout longLinearLayout;
    private HomePresenter homePresenter;
    private int location;//记录滚动位置
    private RelativeLayout home_header_bar;
    private int changeTitleHeight = 100;
    private BGARefreshLayout mRefreshLayout;
    private OverlayLayout overlayLayout;
    private NetWorkLoading networkLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        StatusBarUtil.setLightMode(MainActivity.this);


        homePresenter = new HomePresenter(this);
        longLinearLayout = (LongLinearLayout) findViewById(R.id.long_linearLayout);
        scrollView = (GradationScrollView) findViewById(R.id.scrollView);
        home_header_bar = (RelativeLayout) findViewById(R.id.home_header_bar);
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.rl_refresh);
        overlayLayout = new OverlayLayout(this);
        networkLoading = new NetWorkLoading(this);

        overlayLayout.setOverlayView(R.layout.holder_network);
        overlayLayout.attachTo(mRefreshLayout);


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
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
//        BGARefreshViewHolder refreshViewHolder = new BGAMeiTuanRefreshViewHolder(getActivity(), true);
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this, true));


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
        mRefreshLayout.endRefreshing();


    }


    @Override
    public void showError() {

        Log.e("jinyb", "随机出错了");
        overlayLayout.showOverlay();

    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        homePresenter.start(false);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
