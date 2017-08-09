package com.gzdmg.xmt.pyinterface.response;

/**
 * @author weihongyan
 * @implNote <(▰˘◡˘▰)>
 * @since 09/08/2017 7:21 PM
 */
public class WebResponse<T> {
    private int code = 0;
    private String msg = "succ";
    private T data;

    public WebResponse() {
    }

    public WebResponse success(T t) {
        this.data = t;
        return this;
    }

    public WebResponse error(String msg) {
        return error(msg, 1);
    }

    public WebResponse error(String msg, int code) {
        this.msg = msg;
        this.code = code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
