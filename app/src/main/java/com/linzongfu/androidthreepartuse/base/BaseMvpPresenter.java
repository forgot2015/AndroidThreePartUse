package com.linzongfu.androidthreepartuse.base;

/**
 * Created by Lin ZongFu on 2018/4/13
 */
public interface BaseMvpPresenter<V> {
    void attachView(V view);

    void detachView();

}
