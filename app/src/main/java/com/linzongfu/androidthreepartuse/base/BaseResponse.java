package com.linzongfu.androidthreepartuse.base;

/**
 * Created by Lin ZongFu on 2018/4/13
 * 通用的网络请求回复
 */
public class BaseResponse {
    private int status;
    private Object msg;
    private Object data;
    private boolean success;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", msg=" + msg +
                ", data=" + data +
                ", success=" + success +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
