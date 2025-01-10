package com.chige.tim.domain.reponse;

import lombok.Data;

/**
 * @Author wangyc
 * @Description 响应体
 * @Date 2024/8/3 15:42
 */
@Data
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;

    public Response() {}

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.code = 1;
        response.msg = "success";
        return response;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> response = new Response<>();
        response.setCode(1);
        response.setMsg("success");
        response.setData(data);
        return response;
    }

}
