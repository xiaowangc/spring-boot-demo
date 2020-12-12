package com.chige;

import com.chige.domain.Guest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class GuestValidationTest {

    public static void main(String[] args) {
        //使用Hibernate Validation 框架进行数据验证  【不配合SpringBoot框架的情况下使用】
        // 1.创建普通模式的实例
        Validator validator1 = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Guest>> violationSet = validator1.validate(new Guest("", "role1"));
        for(ConstraintViolation<Guest> constraintViolation : violationSet){
            System.out.println(constraintViolation.getPropertyPath() + "," + constraintViolation.getMessage());
        }

        // 2.创建快速失败模式的实例
        Validator validatorFastFail = Validation.byDefaultProvider()
                .configure().addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory().getValidator();
        Set<ConstraintViolation<Guest>> validateFastFailSet = validatorFastFail.validate(new Guest("", ""));
        for(ConstraintViolation<Guest> violation : validateFastFailSet){
            System.out.println(violation.getPropertyPath() + "," + violation.getMessage());
        }
    }
}
