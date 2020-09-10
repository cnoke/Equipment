package com.knd.library.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.knd.library.EventBus.MessageEvent;
import com.knd.library.ui.BaseActivity;

public abstract class BaseMvpActivity extends BaseActivity implements IBaseView {

    private ProxyActivity mProxyActivity;


    @SuppressWarnings("SameParameterValue")
    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @SuppressWarnings({"unchecked", "TryWithIdenticalCatches"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mProxyActivity = createProxyActivity();
        mProxyActivity.bindPresenter();
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    private ProxyActivity createProxyActivity() {
        if (mProxyActivity == null) {
            return new ProxyActivity(this);
        }
        return mProxyActivity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxyActivity.unbindPresenter();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
