package com.chige.exception;

/**
 * 响应状态码
 *
 * @author chige
 * @data 2020/12/12
 */
public enum ResponseCode {
    /**
     * 响应成功状态码及对应信息
     */
    SUCCESS(10001, "SUCCESS"),
    // 失败状态码
    FAIL(404004, "FAIL"),
    PARAM_INVALID(300001,"参数非法");

    private Integer code;
    private String message;


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

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
