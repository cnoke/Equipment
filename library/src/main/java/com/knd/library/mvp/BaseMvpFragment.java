package com.knd.library.mvp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseMvpFragment extends Fragment implements IBaseView {

    private ProxyFragment mProxyFragment;

    protected abstract @LayoutRes
    int setLayout();

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    @SuppressWarnings("ConstantConditions")
    protected <T extends View> T $(@IdRes int viewId) {
        return this.getView().findViewById(viewId);
    }

    @SuppressWarnings({"unchecked", "TryWithIdenticalCatches"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);

        mProxyFragment = createProxyFragment();
        mProxyFragment.bindPresenter();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(savedInstanceState);
        initData();
    }

    @SuppressWarnings("unchecked")
    private ProxyFragment createProxyFragment() {
        if (mProxyFragment == null) {
            return new ProxyFragment<>(this);
        }
        return mProxyFragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mProxyFragment.unbindPresenter();
    }
}
