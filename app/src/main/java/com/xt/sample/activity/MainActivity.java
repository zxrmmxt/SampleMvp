package com.xt.sample.activity;

import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.main.base.BaseMainView;
import com.xt.sample.mvp.main.MainView;

/**
 * @author xt
 */
public class MainActivity extends BaseActivity<BaseMainView> {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseMainView createMvpView() {
        return new MainView(this);
    }
}