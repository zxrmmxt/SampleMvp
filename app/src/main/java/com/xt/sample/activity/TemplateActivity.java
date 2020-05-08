package com.xt.sample.activity;

import android.Manifest;

import androidx.lifecycle.Observer;

import com.blankj.utilcode.util.PermissionUtils;
import com.xt.common.R;
import com.xt.common.mvp.BaseActivity;
import com.xt.sample.mvp.template.TemplateView;
import com.xt.sample.mvp.template.base.BaseTemplateView;

/**
 * @author xt
 */
public class TemplateActivity extends BaseActivity<BaseTemplateView> {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_template;
    }

    @Override
    protected BaseTemplateView createMvpView() {
        return new TemplateView(this);
    }

}
