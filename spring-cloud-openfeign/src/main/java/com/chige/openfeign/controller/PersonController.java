package com.chige.openfeign.controller;

import com.chige.openfeign.domain.request.response.Response;
import com.chige.openfeign.service.SwaggerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangyc
 * @date 2021/12/2
 */
@RestController
@RequestMapping("/openfeign")
public class PersonController {

    @Resource
    private SwaggerService swaggerService;

    @GetMapping("/guest")
    public Response<String> getGuest() {
        String guest = swaggerService.getGuest();
        return new Response<String>().SUCCESS(guest);
    }
}
