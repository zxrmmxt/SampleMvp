package com.xt.sample.mvp.template;


import com.xt.sample.mvp.template.base.BaseTemplatePresenter;
import com.xt.sample.mvp.template.base.BaseTemplateView;

/**
 * @author xt on 2020/5/6 16:59
 */
class TemplatePresenter extends BaseTemplatePresenter {
    TemplatePresenter(BaseTemplateView view) {
        super(view, new TemplateModel());
    }
}
