package com.chige.openfeign.service;

import com.chige.openfeign.domain.request.response.Response;
import com.chige.openfeign.intergetion.swagger.SwaggerTestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyc
 * @date 2021/12/2
 */
@Service
@Slf4j
public class SwaggerService {

    private final SwaggerTestClient swaggerTestClient;

    @Autowired
    public SwaggerService(SwaggerTestClient swaggerTestClient) {
        this.swaggerTestClient = swaggerTestClient;
    }

    public String getGuest() {
        Response<String> response = null;
        try {
            response = swaggerTestClient.getGuest();
        }catch (Exception e) {
            log.info("调用接口异常：{}", e);
        }
        if (response != null) {
            Integer code = response.getCode();
            if (code.equals(200)) {
                return response.getData();
            }
        }
        return "error";
    }

}
