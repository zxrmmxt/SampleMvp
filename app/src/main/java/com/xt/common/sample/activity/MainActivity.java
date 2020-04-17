package com.xt.common.sample.activity;

import androidx.fragment.app.Fragment;

import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.common.sample.mvp.main.BaseMainView;
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