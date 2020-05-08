package com.xt.sample.mvp.mf;

import com.xt.sample.mvp.mf.base.BaseMfModel;
import com.xt.sample.mvp.mf.base.BaseMfPresenter;

/**
 * @author xt on 2020/5/8 10:40
 */
public class MfPresenter extends BaseMfPresenter {
    @Override
    protected BaseMfModel createModel() {
        return new MfModel();
    }
}
