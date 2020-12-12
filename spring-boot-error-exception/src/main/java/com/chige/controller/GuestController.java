package com.chige.controller;

import com.chige.domain.Guest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/** 使用@Valid Guest guest + BindingResult result
 *  @Valid 注解是用来修饰实体对象的，BindingResult一般只能跟在valid注解后面
 */
@RestController
public class GuestController {

    @PostMapping("/guest")
    public String add(@Valid Guest guest, BindingResult result){
        //BindingResult 跟在由Valid注解修饰的类后面，用来记录前面类出错时的日志信息
        if (result.getErrorCount() > 0){
            List<FieldError> fieldErrorList =  result.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            for(FieldError fieldError : fieldErrorList){
                sb.append(fieldError.getField());
                sb.append("\t");
                sb.append(fieldError.getDefaultMessage());
                sb.append("\n");
            }
            return sb.toString();
        }
        return "success";
    }
}
