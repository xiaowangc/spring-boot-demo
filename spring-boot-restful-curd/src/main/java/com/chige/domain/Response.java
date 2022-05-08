package com.chige.domain;

import com.chige.common.ResponseCode;

/**
 * @author wangyc
 * @date 2022/5/8
 */
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;


    public Response() {
        this.code = ResponseCode.SUCCESS.getStatus();
        this.msg = ResponseCode.SUCCESS.getMessage();
    }

    public Response(T data) {
        this.code = ResponseCode.SUCCESS.getStatus();
        this.msg = ResponseCode.SUCCESS.getMessage();
        this.data = data;
    }

    public Response(T data, String message) {
        this.code = ResponseCode.SUCCESS.getStatus();
        this.msg = message;
        this.data = data;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
