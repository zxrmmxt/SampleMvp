package com.xt.common.sample.mvp.main;

import android.os.Handler;

import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * @author xt on 2020/4/17 12:14
 */
public class MainPresenter extends BaseMainPresenter {
    public MainPresenter(BaseMainView view) {
        super(view, new MainModel());
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
