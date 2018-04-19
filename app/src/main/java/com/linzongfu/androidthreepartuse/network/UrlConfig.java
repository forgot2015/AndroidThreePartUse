package com.linzongfu.androidthreepartuse.network;

/**
 * Created by Lin ZongFu on 2018/4/13
 *  网络请求URL地址统一配置
 * 以下地址顺序按模块来划分
 */
public class UrlConfig {
    /**
     * 一般网络请求的ip
     */
    public static final String HOST_URL = "http://192.168.0.111/";

    /**
     * 登录页-登录
     */
    public static final String GET_USER_LOGIN = "user/login";

    /**
     * 登录页-注册账号
     */
    public static final String GET_REGISTER_ACCOUNT = "user/registerAccount";

    /**
     * 登录页-获取验证码
     */
    public static final String GET_CHECK_CODE = "user/getCheckCode";
}
