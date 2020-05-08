package com.xt.sample.mvp.m.base;

import com.xt.common.mvp.BaseActivity;
import com.xt.common.mvp.BaseView;

/**
 * @author xt on 2020/5/6 16:48
 * 用于copy到自己项目
 */
public abstract class BaseMView extends BaseView<BaseMPresenter> {
    public BaseMView(BaseActivity activity) {
        super(activity);
    }
}
