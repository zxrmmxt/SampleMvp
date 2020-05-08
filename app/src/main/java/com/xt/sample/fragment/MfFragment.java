package com.xt.sample.fragment;

import com.xt.common.R;
import com.xt.common.mvp.BaseFragment;
import com.xt.sample.mvp.m.base.BaseMView;
import com.xt.sample.mvp.mf.MfView;
import com.xt.sample.mvp.mf.base.BaseMfView;

/**
 * @author xt on 2020/5/8 9:53
 */
public class MfFragment extends BaseFragment<BaseMfView> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mf;
    }

    @Override
    protected BaseMfView createMvpView() {
        return new MfView();
    }
}
