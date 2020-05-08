package com.xt.sample.mvp.m;

import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.m.base.BaseMPresenter;
import com.xt.sample.mvp.m.base.BaseMView;

/**
 * @author xt on 2020/5/6 16:58
 * 用于copy到自己项目
 */
public class MView extends BaseMView {

    @Override
    protected BaseMPresenter createPresenter() {
        return new MPresenter();
    }

    @Override
    public void initViews() {
        mActivity.setTitleText("模板");
    }

    @Override
    public void initData() {

    }

    @Override
    public void updateData() {

    }
}
