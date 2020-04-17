package com.xt.common.sample.mvp.main;

import com.xt.common.mvp.BasePresenter;

/**
 * @author xt on 2020/4/17 12:13
 */
public abstract class BaseMainPresenter extends BasePresenter<BaseMainView,BaseMainModel> {
    public BaseMainPresenter(BaseMainView view, BaseMainModel model) {
        super(view, model);
    }

    /**
     * 获取数据
     */
    public abstract void getData();
}
