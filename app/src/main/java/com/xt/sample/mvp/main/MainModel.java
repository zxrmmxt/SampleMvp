package com.xt.sample.mvp.main;

import com.xt.sample.mvp.main.base.BaseMainModel;

/**
 * @author xt on 2020/4/17 12:13
 */
public class MainModel extends BaseMainModel {
    @Override
    public String getData() {
        //一般是http请求，会有异步回调接口,这里直接同步返回
        return "加载数据完成";
    }
}
