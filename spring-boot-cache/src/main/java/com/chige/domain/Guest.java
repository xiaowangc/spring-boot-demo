package com.chige.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
//添加全参构造方法



@Data@AllArgsConstructor

public class Guest implements Serializable {
    //TODO SpringBoot中的缓存应用 常用@Cacheable @CachePut ...

    private Integer id;
    private String name;//姓名
    private String role;//角色




}
