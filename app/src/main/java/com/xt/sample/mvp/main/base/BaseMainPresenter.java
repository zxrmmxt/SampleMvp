package com.xt.sample.mvp.main.base;

import com.xt.common.mvp.BasePresenter;

/**
 * @author xt on 2020/4/17 12:13
 */
public abstract class BaseMainPresenter extends BasePresenter<BaseMainView,BaseMainModel> {
    /**
     * 获取数据
     */
    public abstract void getData();
}
