package com.chige.openfeign.domain.request.response;

import com.chige.openfeign.exception.ResponseCode;

import java.io.Serializable;

/**
 * @author wangyc
 * @date 2021/12/2
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 797246318385975689L;
    private Integer code;

    private String msg;

    private T data;

    public Response() {}

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Response(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMessage();
        this.data = data;
    }
    public Response<T> SUCCESS(T data) {
        return new Response(data);
    }
    public Response FAIL() {
        Response response = new Response();
        response.setCode(ResponseCode.INNER_ERROR.getCode());
        response.setMsg(ResponseCode.INNER_ERROR.getMessage());
        return response;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
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
