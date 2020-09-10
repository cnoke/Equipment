package com.knd.library.config;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.knd.library.BuildConfig;

public enum AppConfig {
    //对象
    INSTANCE;

    public void initConfig(Application application){
        initARouter(application);
    }

    private void initARouter(Application application){
        if (BuildConfig.DEBUG) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        //推荐在Application中初始化
        ARouter.init(application);
    }
}
