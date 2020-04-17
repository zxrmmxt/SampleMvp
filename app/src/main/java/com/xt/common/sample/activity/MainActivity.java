package com.xt.common.sample.activity;

import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.common.sample.mvp.main.base.BaseMainView;
import com.xt.common.sample.mvp.main.MainView;

/**
 * @author xt
 */
public class MainActivity extends BaseActivity<BaseMainView> {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseMainView createDefaultMvpView() {
        return new MainView(this);
    }
}