package com.xt.sample.activity;

import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.m.MView;
import com.xt.sample.mvp.m.base.BaseMView;

/**
 * @author xt
 * 用于copy到自己项目
 */
public class MActivity extends BaseActivity<BaseMView> {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_m;
    }

    @Override
    protected BaseMView createMvpView() {
        return new MView();
    }
}
