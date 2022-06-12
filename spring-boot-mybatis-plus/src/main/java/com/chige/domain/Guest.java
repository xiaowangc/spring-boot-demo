package com.chige.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
//添加全参构造方法

@ToString
@Data
public class Guest implements Serializable {

    private Long id;

    private String name;//姓名
    private String role;//角色


}
