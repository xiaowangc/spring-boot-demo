package com.chige.response;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;

/** 全局统一返回
 * @author 小王
 *
 */
public class CommonResult<T> implements Serializable {

    static final long serialVersionUID = -70348988439L;
    private Integer code;
    private String message;
    private T data;

    public CommonResult(){
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public CommonResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> CommonResult<T> error(CommonResult<?> result) {
        return CommonResult.error(result.getCode(),result.getMessage());
    }

    public static <T> CommonResult<T> error(Integer code,String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public void setCode(Integer code) {
         this.code = code;
    }
    public void setMessage(String message) {
         this.message = message;
    }

    public void setData(T data) {
         this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
