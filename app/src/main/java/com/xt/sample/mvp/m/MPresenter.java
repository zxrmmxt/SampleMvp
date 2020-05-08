package com.xt.sample.mvp.m;


import com.xt.sample.mvp.m.base.BaseMPresenter;
import com.xt.sample.mvp.m.base.BaseMView;

/**
 * @author xt on 2020/5/6 16:59
 * 用于copy到自己项目
 */
class MPresenter extends BaseMPresenter {
    MPresenter(BaseMView view) {
        super(view, new MModel());
    }
}
