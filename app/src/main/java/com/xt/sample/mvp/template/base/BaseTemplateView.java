package com.xt.sample.mvp.template.base;

import com.xt.common.mvp.BaseActivity;
import com.xt.common.mvp.BaseView;

/**
 * @author xt on 2020/5/6 16:48
 */
public abstract class BaseTemplateView extends BaseView<BaseTemplatePresenter> {
    public BaseTemplateView(BaseActivity activity) {
        super(activity);
    }
}
