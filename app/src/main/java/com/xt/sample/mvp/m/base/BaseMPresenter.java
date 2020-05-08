package com.xt.sample.mvp.m.base;

import com.xt.common.mvp.BasePresenter;

/**
 * @author xt on 2020/5/6 16:57
 * 用于copy到自己项目
 */
public abstract class BaseMPresenter extends BasePresenter<BaseMView, BaseMModel> {
    public BaseMPresenter(BaseMView view, BaseMModel model) {
        super(view, model);
    }
}
