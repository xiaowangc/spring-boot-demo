package com.chige.exception;

import lombok.Data;

import java.util.HashMap;

/**
 * @author chige
 * 统一返回值对象
 */
@Data
public class Response {
    /**
     * 默认定义的是 成功时的状态码和对象的信息
     */
    private Integer code = 0;
    private String message = "success";
    private Long time = System.currentTimeMillis();
    private String version = "0.0.1";
    private Object data = new HashMap<String,Object>();

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }



}
