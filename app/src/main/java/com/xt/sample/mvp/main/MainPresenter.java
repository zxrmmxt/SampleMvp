package com.xt.sample.mvp.main;

import android.os.Handler;

import com.blankj.utilcode.util.ToastUtils;
import com.xt.sample.mvp.main.base.BaseMainModel;
import com.xt.sample.mvp.main.base.BaseMainPresenter;
import com.xt.sample.mvp.main.base.BaseMainView;

/**
 * @author xt on 2020/4/17 12:14
 */
public class MainPresenter extends BaseMainPresenter {
    @Override
    protected BaseMainModel createModel() {
        return new MainModel();
    }

    @Override
    public void initData() {
        getData();
    }

    @Override
    public void getData() {
        ToastUtils.showShort("加载中...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String data = mModel.getData();
                mView.updateViewData(data);
            }
        }, 2000);
    }
}
