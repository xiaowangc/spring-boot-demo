package com.chige.exception;



public enum ResponseCode {

    /**
     *  成功
     */
    SUCCESS(1,"成功"),

    /** 10001 - 19999
     *  服务端，系统内部错误
     */
    SERVER_ERROR(10001,"系统内部出错"),
    PARAM_INVALID(10002,"参数校验有误！"),
    /** 30001 - 39999
     *  业务导致的错误
     */
    SYS_USER_EXIST(30001,"角色已经存在！"),
    SPECIAL_NO_FUND(30002,"资讯专题不存在"),
    SAVE_FAIL(30003,"保存失败"),
    LIKE_FAIL(30004,"点赞失败"),
    UNLIKE_FAIL(30005,"取消点赞失败"),
    /** 40001 - 49999
     *  调用第三方出错
     */


    ;

    public Integer code;
    public String msg;

    ResponseCode(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    ResponseCode() {

    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
