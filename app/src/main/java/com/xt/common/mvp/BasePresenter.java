package com.xt.common.mvp;

/**
 * @author xt on 2020/4/16 11:26
 */
public abstract class BasePresenter<MvpView extends BaseView, MvpModel extends BaseModel> {
    protected MvpView  mView;
    protected MvpModel mModel;

    public BasePresenter(MvpView view) {
        mView = view;
    }

    public BasePresenter(MvpView view, MvpModel model) {
        mView = view;
        mModel = model;
    }

}
