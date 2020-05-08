package com.xt.sample.mvp.mf;

import com.xt.sample.mvp.mf.base.BaseMfPresenter;
import com.xt.sample.mvp.mf.base.BaseMfView;

/**
 * @author xt on 2020/5/8 10:39
 */
public class MfView extends BaseMfView {
    @Override
    protected BaseMfPresenter createPresenter() {
        return new MfPresenter();
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void updateData() {

    }
}
