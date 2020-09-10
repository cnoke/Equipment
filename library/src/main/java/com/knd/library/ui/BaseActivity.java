package com.knd.library.ui;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.knd.library.EventBus.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends Activity {

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        EventBus.getDefault().register(this);

        initViews();
        initData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEvent(MessageEvent messageEvent) {
        //Do Nothing
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
