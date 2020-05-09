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

    protected BaseActivity   mActivity;
    protected CommonFragment mFragment;
    protected View           mFragmentContentView;

    /**
     * 实例化Presenter的子类对象
     *
     * @return
     */
    protected abstract MvpPresenter createPresenter();


    /**
     * 初始化控件
     */
    protected abstract void initViews();

    final void init(BaseActivity activity) {
        mActivity = activity;
        ButterKnife.bind(this, activity);
        attachUi(activity);
        mPresenter = createPresenter();
        mPresenter.setView(this);
        initViews();
        mPresenter.initData();
    }

    final void init(CommonFragment fragment, View fragmentContentView) {
        ButterKnife.bind(this, fragmentContentView);
        attachUi(fragment);
        mFragment = fragment;
        mFragmentContentView = fragmentContentView;
        mPresenter = createPresenter();
        mPresenter.setView(this);
        initViews();
    }

    final void attachUi(Object ui) {
        mUiSoftReference = new SoftReference<>(ui);
    }

    final void detachUi() {
        if (mUiSoftReference != null) {
            mUiSoftReference.clear();
        }
        mPresenter.onDetachView();
    }


    /**
     * 异步刷新UI界面时一定要调用此方法判断界面是否还在
     *
     * @return
     */
    public final boolean isUiAttached() {
        return mUiSoftReference != null && mUiSoftReference.get() != null;
    }

    public final MvpPresenter getPresenter() {
        return mPresenter;
    }

    public final BaseActivity getActivity() {
        return mActivity;
    }
}
