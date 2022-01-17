package com.chige.retrying;



public enum ResponseCode {
    SUCCESS(1,"success"),
    FAIL(-1,"fail");

    final private Integer code;
    final private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
