package com.knd.library.mvp;

public interface IBasePresenter {

    void attach(IBaseView view);

    void detach();
}
