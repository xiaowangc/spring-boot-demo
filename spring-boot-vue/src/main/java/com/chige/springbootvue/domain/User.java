package com.chige.springbootvue.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Setter
@Getter
public class User {
    private String userName;
    private String password;
}
