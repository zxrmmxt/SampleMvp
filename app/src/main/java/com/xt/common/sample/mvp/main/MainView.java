package com.xt.common.sample.mvp.main;

import android.app.Activity;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;

import butterknife.BindView;

/**
 * @author xt on 2020/4/17 12:12
 */
public class MainView extends BaseMainView {
    @BindView(R.id.textView)
    TextView mTextView;

    public MainView(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected BaseMainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void initViews() {
        mActivity.setTitleText("MainActivity");
    }

    @Override
    public void initData() {
        mPresenter.getData();
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
