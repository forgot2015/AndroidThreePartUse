package com.linzongfu.androidthreepartuse.base;

import android.app.Fragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by Lin ZongFu on 2018/4/13
 */
public class BaseFragment extends Fragment {
    protected Disposable disposable;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unSubscribe();
    }

    protected void unSubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}