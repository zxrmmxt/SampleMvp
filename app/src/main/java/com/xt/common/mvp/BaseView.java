package com.xt.common.mvp;

import android.app.Activity;
import android.view.View;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;

/**
 * @author xt on 2020/4/16 11:18
 */
public abstract class BaseView<MvpPresenter extends BasePresenter> {
    protected MvpPresenter          mPresenter;
    /**
     * Activity或Fragment的引用
     */
    protected SoftReference<Object> mUiSoftReference;

    protected BaseActivity mActivity;
    protected View     mFragmentContentView;

    /**
     * 实例化Presenter的子类对象
     *
     * @return
     */
    protected abstract MvpPresenter createPresenter();


    /**
     * 初始化控件
     */
    public abstract void initViews();

    /**
     * 初始化数据
     */
    public abstract void initData();

    public BaseView(BaseActivity activity) {
        ButterKnife.bind(this, activity);
        mActivity = activity;
        mPresenter = createPresenter();
    }

    /**
     * @param fragmentContentView Fragment的contentView
     */
    public BaseView(View fragmentContentView) {
        ButterKnife.bind(this, fragmentContentView);
        mFragmentContentView = fragmentContentView;
        mPresenter = createPresenter();
    }

    public void attachUi(Object ui) {
        mUiSoftReference = new SoftReference<>(ui);
    }

    public void detachUi() {
        if (mUiSoftReference != null) {
            mUiSoftReference.clear();
        }
        onDetachView();
    }

    public void onDetachView() {
    }


    /**
     * 异步刷新UI界面时一定要调用此方法判断界面是否还在
     *
     * @return
     */
    public boolean isUiAttached() {
        return mUiSoftReference != null && mUiSoftReference.get() != null;
    }

}
