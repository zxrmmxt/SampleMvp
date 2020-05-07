package com.xt.common.topbar;

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
    public View      mTopBarContainer;
    public ImageView mIvRight;

    public static TopBarHolder init(final Activity activity, int titleRes) {
        TopBarHolder topBarHolder = new TopBarHolder();
        topBarHolder.mTopBarContainer = activity.findViewById(R.id.topBarContainer);
        topBarHolder.mIvRight = activity.findViewById(R.id.ivRight);
        topBarHolder.mImageViewBack = activity.findViewById(R.id.imageViewBack);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Android5.0以上要适配沉浸式状态栏
            topBarHolder.mTopBarContainer.setPadding(topBarHolder.mTopBarContainer.getPaddingLeft(), StatusBarUtil.getStatusBarHeight(activity) + topBarHolder.mTopBarContainer.getPaddingTop()
                    , topBarHolder.mTopBarContainer.getPaddingRight(), topBarHolder.mTopBarContainer.getPaddingBottom());
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
