package com.linzongfu.androidthreepartuse.network.api;


import com.linzongfu.androidthreepartuse.base.BaseResponse;
import com.linzongfu.androidthreepartuse.network.UrlConfig;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lin ZongFu on 2018/4/13
 * 学习用RxJava来写请求接口
 */
public interface AccountApi {
    /**
     * 用户登陆接口
     *
     * @param phone    登陆手机号
     * @param password 登陆密码
     * @return
     */
    @GET(UrlConfig.GET_USER_LOGIN)
    Observable<BaseResponse> userLogin(@Query("phone") String phone,
                                       @Query("password") String password);

    /**
     * 用户注册接口
     * 直接查询法， search?q=query
     *
     * @param mobilePhone 注册手机号
     * @param checkCode   短信验证码
     * @param passWord    注册密码
     * @param source      注册来源
     * @return
     */
    @GET(UrlConfig.GET_REGISTER_ACCOUNT)
    Observable<BaseResponse> signupAccount(@Query("mobilePhone") String mobilePhone,
                                           @Query("checkCode") String checkCode,
                                           @Query("passWord") String passWord,
                                           @Query("source") long source);

    //    路径法 data/2/3
    @GET("data/{number}/{page}")
    Observable<BaseResponse> getData(@Path("number") int number, @Path("page") int page);

//    @QueryMap(GET请求):
//    当然如果入参比较多，就可以把它们都放在Map中，例如：
    @GET("book/search")
    Observable<BaseResponse> getBook(@QueryMap Map<String, String> options);
}
