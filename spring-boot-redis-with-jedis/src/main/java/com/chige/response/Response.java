package com.chige.response;


import cn.hutool.http.HttpStatus;
import com.chige.exception.ResponseCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {

    /**
     *  1成功 其他失败
     */
    public Integer code;

    public String msg;

    public Map<String,Object> data;

    /**
     *  构造方法私有，里面的方法都是静态方法，达到保护属性的作用
     */
    private Response() {
    }
//    public Response() {
//        code = ResponseCode.SUCCESS.getCode();
//        msg = ResponseCode.SUCCESS.getMsg();
//        data = (T) new HashMap<>();
//    }

    /**
     *  使用链式编程
     */
    public static  Response ok() {
        Response response = new Response();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        return response;
    }
    public static  Response error() {
        Response response = new Response();
        response.setCode(ResponseCode.SERVER_ERROR.getCode());
        response.setMsg(ResponseCode.SERVER_ERROR.getMsg());
        return response;
    }
    public static Response error(String msg) {
        Response response = new Response();
        response.setCode(HttpStatus.HTTP_BAD_REQUEST);
        response.setMsg(msg);
        return response;
    }
    public static Response error(Integer code,String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public Response code(Integer code) {
        this.setCode(code);
        return this;
    }
    public Response msg(String msg) {
        this.setMsg(msg);
        return this;
    }
    public Response data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }
    public Response data(String key,Object obj) {
        Map<String,Object> map = new HashMap<>(2);
        map.put(key,obj);
        this.data(map);
        return this;
    }

    public static Response error(ResponseCode responseCode) {
        Response errorRes = error();
        errorRes.code(responseCode.getCode());
        errorRes.msg(responseCode.getMsg());
        return errorRes;
    }
    public static Response error(ResponseCode responseCode,String message) {
        Response errorRes = error();
        errorRes.code(responseCode.getCode());
        errorRes.msg(message);
        return errorRes;
    }

//    public Response(ResponseCode responseCode) {
//        code = responseCode.getCode();
//        msg = responseCode.getMsg();
//    }



}
