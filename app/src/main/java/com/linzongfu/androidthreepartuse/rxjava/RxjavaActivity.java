package com.linzongfu.androidthreepartuse.rxjava;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.linzongfu.androidthreepartuse.R;
import com.linzongfu.androidthreepartuse.base.BaseResponse;
import com.linzongfu.androidthreepartuse.network.Network;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxjavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        //START DIFFERENCE BETWEEN MAP AND FLATMAP
        Observable.just("item1")
                .map( str -> {
                    System.out.println("inside the map " + str);
                    return str;
                })
                .subscribe(System.out::println);

        Observable.just("item2")
                .flatMap( str -> {
                    System.out.println("inside the flatMap " + str);
                    return Observable.just(str + "+", str + "++" , str + "+++");
                })
                .subscribe(System.out::println);
        //END DIFFERENCE BETWEEN MAP AND FLATMAP
    }

    public void getUserInfoAndDoOtherThing(){
//        先获取用户信息，再根据用户信息里的字段去调别的接口
        Network.getAccountApi()
                .signupAccount("11111","1002","123456",1)
                .flatMap(new Function<BaseResponse, ObservableSource<BaseResponse>>() {
                    @Override
                    public ObservableSource<BaseResponse> apply(BaseResponse baseResponse) throws Exception {
                        return Network.getAccountApi()
                                .userLogin("1591521","232");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponse>() {
                    @Override
                    public void accept(BaseResponse baseResponse) throws Exception {
                        if (baseResponse.isSuccess()) {
                            LogUtils.d("ttt");
                        }
                    }
                });
    }

    //        替代Handler使用
    public void doAfterSeconds(){
        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        ToastUtils.showShort("延迟2秒执行");
                    }
                });
    }


}
