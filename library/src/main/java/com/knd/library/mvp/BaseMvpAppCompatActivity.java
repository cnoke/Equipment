package com.knd.library.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMvpAppCompatActivity extends AppCompatActivity implements IBaseView {

    private ProxyActivity mProxyActivity;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();

    protected abstract void initData();


    @SuppressWarnings("SameParameterValue")
    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @SuppressWarnings({"unchecked", "TryWithIdenticalCatches"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);

        mProxyActivity = createProxyActivity();
        mProxyActivity.bindPresenter();

        initViews();
        initData();
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
