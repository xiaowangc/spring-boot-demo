package com.chige.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


import java.io.Serializable;
//添加全参构造方法

/** 数据验证方式
 * @NotBlank  用来验证String类型的
 * @NotNUll  用来验证基本类型的 如Integer
 *
 * @NotEmpty 用来验证集合的 如Map<String , String> map = new HashMap(); map.put("","");
 *          键和值都为空串，使用 NotEmpty 注解可验证出来
 * @Valid 后面修饰实体类，实体类上的属性可能都有上面三种数据验证方式来修饰
 * BindingResult 跟在Valid后面，记录所有可能出错的属性的记录
 *
 */
@Data@AllArgsConstructor
public class Guest implements Serializable {

    @NotBlank(message = "guest姓名不能为Null")//数据验证注解  message中的提示信息可以放在ValidationMessages.properties配置文件中
    private String name;//姓名
    @NotBlank(message = "guest角色不能为空串")
    private String role1;//角色


}
