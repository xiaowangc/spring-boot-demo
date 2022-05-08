package com.chige.springannotation.validation;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangyc
 * @date 2022/3/10
 */
@ToString
@Data
public class Person {

    @NotNull
    private String name;
    private Integer age;
}
