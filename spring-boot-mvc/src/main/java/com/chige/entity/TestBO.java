package com.chige.entity;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author wangyc
 * @date 2022/8/31
 */
public class TestBO {
    @NotNull(message = "属性不能为看那个")
    private Long userId;
    @NotNull
    private Integer userProId;

    public TestBO() {
    }

    public TestBO(@Validated @NotNull(message = "不能为空") Long userId, Integer userProId) {
        this.userId = userId;
        this.userProId = userProId;
    }

    @Override
    public String toString() {
        return "TestBO{" +
                "userId=" + userId +
                ", userProId=" + userProId +
                '}';
    }
}
