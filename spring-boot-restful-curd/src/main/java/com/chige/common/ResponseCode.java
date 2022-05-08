package com.chige.common;

/**
 * @author wangyc
 * @date 2022/5/8
 */
public enum ResponseCode {

    SUCCESS(1,"success"),
    FAIL(0,"FAIL"),

    SERVER_ERROR(500, "服务端错误"),

    ;


    private Integer status;
    private String message;

    ResponseCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
