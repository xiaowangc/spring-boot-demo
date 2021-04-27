package com.chige.exception;

/** 响应异常
 * @author chige
 * @date 2020/12/12
 */
public class ResponseException extends Exception{
    private ResponseCode responseCode;

    public ResponseException(ResponseCode responseCode){
        // 异常信息来自ResponseCode中定义好的异常信息
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    /**
     *  自定义异常信息
     * @param responseCode 响应对象
     * @param message 异常信息
     */
    public ResponseException(ResponseCode responseCode,String message){
        super(message);
        responseCode.setMessage(message);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }






}
