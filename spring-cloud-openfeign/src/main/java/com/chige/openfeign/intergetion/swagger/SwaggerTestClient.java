package com.chige.openfeign.intergetion.swagger;

import com.chige.openfeign.config.DisableHystrixConfiguration;
import com.chige.openfeign.domain.request.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangyc
 * @date 2021/12/2
 */
@FeignClient(name = "swagger-test", url = "http://localhost:8094/", configuration = {DisableHystrixConfiguration.class})
public interface SwaggerTestClient {

    @GetMapping(value = "/guest")
    Response<String> getGuest();

}
