package com.chige.springbootkafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
}
