package com.xt.common.sample.mvp.main;

import android.app.Activity;

import com.xt.common.mvp.BaseActivity;
import com.xt.common.mvp.BaseView;

/**
 * @author xt on 2020/4/17 12:12
 */
public abstract class BaseMainView extends BaseView<BaseMainPresenter> {
    public BaseMainView(BaseActivity activity) {
        super(activity);
    }

    /**
     * 刷新界面数据
     * @param data
     */
    public abstract void updateViewData(String data);
}
