package com.xt.sample.mvp.main;

import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.main.base.BaseMainPresenter;
import com.xt.sample.mvp.main.base.BaseMainView;

import butterknife.BindView;

/**
 * @author xt on 2020/4/17 12:12
 */
public class MainView extends BaseMainView {
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected BaseMainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initViews() {
        mActivity.setTitleText("MainActivity");
    }

    @Override
    public void updateViewData(final String data) {
        if (isUiAttached()) {
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ToastUtils.showShort(data);
                }
            });
        }
    }
}
