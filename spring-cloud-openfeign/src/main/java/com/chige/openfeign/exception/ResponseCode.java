package com.chige.openfeign.exception;

/**
 * @author wangyc
 * @date 2021/12/2
 */
public enum ResponseCode {

    SUCCESS(200,"success"),


//    内部服务错误
    INNER_ERROR(404,"找不到资源"),


    ;


    private Integer code;
    private String message;

    ResponseCode() {}

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
