package com.chige.exception;


import org.apache.http.protocol.ResponseServer;

public class ResponseException extends RuntimeException {

    private ResponseCode responseCode;
    private String msg;
    private Integer code;

    public ResponseException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }

    public ResponseException(String msg) {
        super(msg);
        this.msg = msg;
    }


    public ResponseException(ResponseCode responseCode, String msg) {
        super(msg);
        responseCode.setMsg(msg);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public Integer getCode() {
        return this.code;
    }
}
