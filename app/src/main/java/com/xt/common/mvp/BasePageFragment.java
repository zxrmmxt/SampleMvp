package com.xt.common.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author xt on 2019/8/19 13:05
 * 1、Activity+ViewPager+BasePageFragment
 * 2、Activity+BaseFragment+ViewPager+BasePageFragment
 */
public abstract class BasePageFragment<MvpView extends BaseView> extends CommonFragment<MvpView> {
    private static final String  TAG          = BasePageFragment.class.getSimpleName();
    private              boolean mIsFirstLoad = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            initMvpView();
        } else {
            mMvpView.attachUi(this);
        }
        return mRootView;
    }

    protected abstract int getLayoutId();

    @Override
    public void onResume() {
        super.onResume();
        loadDataLogic();
    }

    /**
     * 如果我们使用的是FragmentPagerAdapter，
     * 切换导致Fragment被销毁时是不会执行onDestory()和onDetach()方法的，
     * 只会执行到onDestroyView()方法，因此在onDestroyView()方法中我们还需要将{@link #mIsFirstLoad}这个变量重置，
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsFirstLoad = true;
    }

    private void loadDataLogic() {
        if (mIsFirstLoad) {
            mIsFirstLoad = false;
            mMvpView.getPresenter().initData();
        }
        mMvpView.getPresenter().resumeData();
    }
}
