package com.xt.common.base;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xt.common.R;
import com.xt.common.statusbar.StatusBarUtil;

/**
 * @author xt on 2019/11/19 15:27
 */
public class TopBarHolder {
    public ImageView mImageViewBack;
    public TextView  mTextViewTitle;
    public View      topPanel;
    public ImageView ivRight;

    public static TopBarHolder init(final Activity activity, int titleRes) {
        TopBarHolder topBarHolder = new TopBarHolder();
        topBarHolder.topPanel = activity.findViewById(R.id.topBarPanel);
        topBarHolder.ivRight = activity.findViewById(R.id.ivRight);
        topBarHolder.mImageViewBack = activity.findViewById(R.id.imageViewBack);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Android5.0以上要适配沉浸式状态栏
            topBarHolder.topPanel.setPadding(topBarHolder.topPanel.getPaddingLeft(), StatusBarUtil.getStatusBarHeight(activity) + topBarHolder.topPanel.getPaddingTop()
                    , topBarHolder.topPanel.getPaddingRight(), topBarHolder.topPanel.getPaddingBottom());
        }
        topBarHolder.mImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
        topBarHolder.mTextViewTitle = activity.findViewById(R.id.textViewTitle);
        if (titleRes <= 0) {
            topBarHolder.mTextViewTitle.setText("");
        } else {
            topBarHolder.mTextViewTitle.setText(titleRes);
        }
        return topBarHolder;
    }

    public static TopBarHolder init(final Activity activity) {
        return init(activity, 0);
    }
}
