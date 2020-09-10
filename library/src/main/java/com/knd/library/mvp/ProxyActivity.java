package com.knd.library.mvp;

public class ProxyActivity<V extends IBaseView> extends ProxyImpl {
    public ProxyActivity(V view) {
        super(view);
    }
}
