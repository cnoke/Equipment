package com.knd.library.mvp;

public class ProxyFragment<V extends IBaseView> extends ProxyImpl {
    public ProxyFragment(V view) {
        super(view);
    }
}
