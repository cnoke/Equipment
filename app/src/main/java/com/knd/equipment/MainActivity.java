package com.knd.equipment;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.knd.library.mvp.BaseMvpActivity;
import com.knd.library.mvp.InjectPresenter;

public class MainActivity extends BaseMvpActivity implements MainContract.IMainView {

    @InjectPresenter
    private MainPresenter mPresenter;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void succes(String content) {

    }
}
