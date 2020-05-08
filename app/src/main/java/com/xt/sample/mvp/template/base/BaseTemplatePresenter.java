package com.xt.sample.mvp.template.base;

import com.xt.common.mvp.BasePresenter;

/**
 * @author xt on 2020/5/6 16:57
 */
public abstract class BaseTemplatePresenter extends BasePresenter<BaseTemplateView, BaseTemplateModel> {
    public BaseTemplatePresenter(BaseTemplateView view, BaseTemplateModel model) {
        super(view, model);
    }
}
