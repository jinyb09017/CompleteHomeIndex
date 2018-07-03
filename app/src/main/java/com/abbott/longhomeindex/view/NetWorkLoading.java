package com.abbott.longhomeindex.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abbott.longhomeindex.R;


/**
 * @author jyb jyb_96@sina.com on 2016/11/14.
 * @version V1.0
 * @Description:加载中dialog
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class NetWorkLoading {
    private Dialog dialog;
    private int showNum = 0;//记录显示的次数
    private Context mContext;
    private boolean show = true;
    TextView tipTextView;

    public NetWorkLoading(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 显示dialog
     *
     * @param msg
     */


    public Dialog showDialog(String msg) {
        if (mContext != null && mContext instanceof Activity) {
            dialog = showDialog(mContext, msg);
        }
        return dialog;

    }

    @Deprecated
    public Dialog showDialog(Context context, String msg) {
        this.mContext = context;

        if (dialog == null) {
            create(context, msg);

        }

        if (!dialog.isShowing() && mContext != null && mContext instanceof Activity) {
            Activity activity = (Activity) mContext;
            if (!activity.isFinishing() && show) {
                dialog.show();
            }
        }
        showNumAdd();
        return dialog;
    }

    public void dismissDialog() {
        showNumNin();

        if (showNum == 0) {


            if (dialog != null && mContext != null && mContext instanceof Activity) {
                Activity activity = (Activity) mContext;
                if (!activity.isFinishing()) {
                    dialog.dismiss();
                }

            }

        }
    }

    synchronized void showNumAdd() {
        showNum++;
    }

    synchronized void showNumNin() {
        if (showNum == 0) {//bug
            return;
        }
        showNum--;
    }

    public void create(Context context, String message) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_dialog_loading2, null);// 得到加载view
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.dialog_view);// 加载布局
        ImageView spaceshipImage = (ImageView) view.findViewById(R.id.dialog_loading_img);
        tipTextView = (TextView) view.findViewById(R.id.dialog_loading_text);// 提示文字
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(spaceshipImage, "rotation", 360);
        objectAnimator1.setInterpolator(new LinearInterpolator());
        objectAnimator1.setDuration(2000);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator1.start();

        if (TextUtils.isEmpty(message)) {// 设置加载信息 没有则隐藏
            tipTextView.setVisibility(View.GONE);
        } else {
            tipTextView.setVisibility(View.VISIBLE);
            tipTextView.setText(message);
        }

        dialog = new Dialog(context, R.style.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.addContentView(layout, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.setContentView(layout);
    }



    public boolean isDialogShowing() {
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    public void setCancelOk(boolean flag) {
        if (dialog == null) {
            return;
        }
        dialog.setCancelable(flag);
    }


    public void setTipTextView(String msg) {
        tipTextView.setText(msg);
    }
}
