package com.xt.common.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.xt.common.R;
import com.xt.common.topbar.TopBarHolder;
import com.xt.common.statusbar.ImmersiveStatusBarUtils;

/**
 * @author xt
 * @date 2017/3/20
 */

public abstract class BaseActivity<MvpView extends BaseView> extends AppCompatActivity {
    private static final String       TAG = BaseActivity.class.getSimpleName();
    private              FrameLayout  mRootLayout;
    private              FrameLayout  mContentContainer;
    protected            TopBarHolder mTopBarHolder;

    /**
     * 默认的MvpView
     */
    protected MvpView mMvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView(savedInstanceState);
        {
            //设置沉浸式状态栏
            ImmersiveStatusBarUtils.setImmersiveStatus(getWindow());
            //设置状态栏颜色
            /*StatusBarUtil.setColor(this, getStatusBarColorRes());*/
        }
        setContentView(R.layout.activity_base);
        afterSetContentView(savedInstanceState);
        {
            mRootLayout = findViewById(R.id.rootLayout);
            mContentContainer = findViewById(R.id.contentContainer);
            LayoutInflater layoutInflater = getLayoutInflater();
            layoutInflater.inflate(getLayoutResId(), mContentContainer, true);

            mTopBarHolder = TopBarHolder.init(this);
        }
        initMvpView();
    }

    protected void beforeSetContentView(Bundle savedInstanceState) {

    }

    protected void afterSetContentView(Bundle savedInstanceState) {

    }

    protected abstract int getLayoutResId();

    protected int getTitleLayoutRes() {
        return R.layout.layout_title_bar;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.anim_no);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_no, R.anim.out_to_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMvpView.getPresenter().resumeData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyView();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return new HideInput().dispatchTouchEvent(ev);
    }


    /**********************************设置状态栏颜色*****************************************/
    protected int getStatusBarColorRes() {
        return android.R.color.transparent;
    }

    /**********************************设置状态栏颜色*****************************************/
    protected void setBackgroundResource(int backgroundRes) {
        mRootLayout.setBackgroundResource(backgroundRes);
    }

    /**
     * 去除状态栏全屏，一般在app的第一个界面中调用，要在{@link #setContentView(int)}方法之前调用
     */
    public void setFullscreen() {
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void hideTitleBar() {
        mTopBarHolder.mTopBarContainer.setVisibility(View.GONE);
    }

    public void setTitleText(int stringTitle) {
        mTopBarHolder.mTextViewTitle.setText(stringTitle);
    }

    public void setTitleText(String stringTitle) {
        mTopBarHolder.mTextViewTitle.setText(stringTitle);
    }

    /**
     * 点击空白地方，输入法隐藏
     */
    private class HideInput {
        private boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (isShouldHideInput(v, ev)) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                    onHideSoftInputFromWindow();
                }
                return BaseActivity.super.dispatchTouchEvent(ev);
            }
            // 必不可少，否则所有的组件都不会有TouchEvent了
            if (getWindow().superDispatchTouchEvent(ev)) {
                return true;
            }
            return onTouchEvent(ev);
        }

        private void onHideSoftInputFromWindow() {
            //键盘隐藏后，界面上的edittext的光标要隐藏
        }

        private boolean isShouldHideInput(View v, MotionEvent event) {
            if (v instanceof EditText) {
                int[] leftTop = {0, 0};
                //获取输入框当前的location位置
                v.getLocationInWindow(leftTop);
                int left   = leftTop[0];
                int top    = leftTop[1];
                int bottom = top + v.getHeight();
                int right  = left + v.getWidth();
                if (event.getX() > left && event.getX() < right
                        && event.getY() > top && event.getY() < bottom) {
                    // 点击的是输入框区域，保留点击EditText的事件
//                ((EditText) v).setCursorVisible(true);
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
        /*************点击空白地方，输入法隐藏******************/
    }

    private void initMvpView() {
        mMvpView = createMvpView();
        mMvpView.init(this);
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