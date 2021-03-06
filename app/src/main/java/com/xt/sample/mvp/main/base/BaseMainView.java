package com.xt.sample.mvp.main.base;

import com.xt.common.mvp.BaseActivity;
import com.xt.common.mvp.BaseView;

/**
 * @author xt on 2020/4/17 12:12
 */
public abstract class BaseMainView extends BaseView<BaseMainPresenter> {
    /**
     * 刷新界面数据
     * @param data
     */
    public abstract void updateViewData(String data);
}
