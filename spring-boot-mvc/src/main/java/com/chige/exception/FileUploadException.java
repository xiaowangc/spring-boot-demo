package com.chige.exception;

import com.chige.response.ResponseCode;

/**
 * @author wangyc
 * @date 2022/8/15
 */
public class FileUploadException extends RuntimeException {

    private final Integer code;

    public FileUploadException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
    }

    public FileUploadException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
