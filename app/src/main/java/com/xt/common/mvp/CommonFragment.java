package com.xt.common.mvp;

import android.view.View;

import androidx.fragment.app.Fragment;

/**
 * @author xt on 2019/11/12 9:46
 */
public abstract class CommonFragment<MvpView extends BaseView> extends Fragment {
    protected View    mRootView;
    /**
     * 默认的MvpView
     */
    protected MvpView mMvpView;

    protected void initMvpView() {
        mMvpView = createMvpView();
        if (mMvpView != null) {
            mMvpView.init(this, mRootView);
        }
    }

    /**
     * 实例化默认的View
     *
     * @return
     */
    protected abstract MvpView createMvpView();

    private void destroyView() {
        if ((mMvpView != null)) {
            mMvpView.detachUi();
        }
    }
}
