package com.xt.common.mvp;

/**
 * @author xt on 2020/4/16 11:26
 */
public abstract class BasePresenter<MvpView extends BaseView, MvpModel extends BaseModel> {
    protected MvpView  mView;
    protected MvpModel mModel;

    void setView(MvpView view) {
        mView = view;
        mModel = createModel();
    }

    protected abstract MvpModel createModel();

    protected void initData() {

    }

    protected void resumeData() {

    }

    public void onDetachView() {

    }
}
