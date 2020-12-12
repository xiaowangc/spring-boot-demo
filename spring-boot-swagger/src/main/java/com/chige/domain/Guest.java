package com.chige.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

//添加全参构造方法

@Data@AllArgsConstructor
@ApiModel("嘉宾")
public class Guest {
    @ApiModelProperty("姓名")
    private String name;//姓名
    @ApiModelProperty("角色")
    private String role;//角色

}
