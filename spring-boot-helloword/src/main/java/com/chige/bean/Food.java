package com.chige.bean;

import com.chige.util.Validate;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *  改bean表示需要进行校验的对象，一般为前端接收对象xxxRequest
 *  请求对象如果实现了Validate接口，则表示需要进行参数校验
 */
@Data
public class Food implements Validate {
    @NotEmpty
    private String rice;
    @NotBlank
    private String meat;
    public Food(){}
    public Food(String rice,String meat){
        this.rice = rice;
        this.meat = meat;
    }


}
