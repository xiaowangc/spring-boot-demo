package com.chige.response;

public enum ResponseCode {
    /**
     *  成功
     */
    SUCCESS(1,"成功"),
    /**
     *  失败
     */
    FAIL(40001,"错误"),


    MISSING_REQUEST_PARAM_ERROR(200100100,"参数缺失！"),

    SYS_ERROR(400100100,"系统异常");
    private final Integer code;
    private final String message;

    ResponseCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
