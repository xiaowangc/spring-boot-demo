package com.chige.openfeign.intergetion.swagger;

import com.chige.openfeign.domain.request.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangyc
 * @date 2021/12/4
 */
@Slf4j
@Component
public class MyHystrix implements SwaggerTestClient {

    @Override
    public Response<String> getGuest() {
        log.info("开启断路器保护");
        return null;
    }
}
