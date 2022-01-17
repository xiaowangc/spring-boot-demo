package com.chige.retrying;

import java.net.ResponseCache;

public class ResponseException extends RuntimeException {
    private ResponseCode responseCode;
    private String message;
    public ResponseException(String message) {
        super(message);
    }
    public ResponseCode error() {
        return ResponseCode.FAIL;
    }
}
