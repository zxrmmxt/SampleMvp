package com.xt.sample.mvp.template;

import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.template.base.BaseTemplatePresenter;
import com.xt.sample.mvp.template.base.BaseTemplateView;

/**
 * @author xt on 2020/5/6 16:58
 */
public class TemplateView extends BaseTemplateView {
    public TemplateView(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected BaseTemplatePresenter createPresenter() {
        return new TemplatePresenter(this);
    }

    @Override
    public void initViews() {
        mActivity.setTitleText("模板");
    }

    @Override
    public void initData() {

    }
}
