package com.knd.library.app;

import android.app.Application;

import com.knd.library.config.AppConfig;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppConfig.INSTANCE.initConfig(this);
        //在子线程中初始化
        InitializeService.start(this);
    }

}
