package com.chige.expand.bean;

import lombok.Data;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2025/1/10 00:09
 */
@Data
public class MyBean {

    @AutowireCustom
    private String customField;
}
