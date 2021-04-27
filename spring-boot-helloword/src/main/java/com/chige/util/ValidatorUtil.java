package com.chige.util;

import com.chige.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.chige.exception.ResponseCode.PARAM_INVALID;

/**
 *  *  该bean表示需要进行校验的对象，一般为前端接收对象xxxRequest
 *  *  请求对象如果实现了Validate接口，则表示需要进行参数校验
 */
@Slf4j
public class ValidatorUtil {
    /**
     *
     * @param validate 参数类型为：实现Validate接口的请求对象
     * @return
     * @throws ResponseException 如果参数校验有错误，需要返回响应错误码及错误信息，否则不返回异常
     */
    public static boolean validate(Validate validate) throws ResponseException {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Validate>> set = validator.validate(validate);
        if (!set.isEmpty()){
            for (ConstraintViolation<Validate> violation : set) {
                log.info("参数校验不通过,错误信息为:"+ violation.getMessage());
                throw new ResponseException(PARAM_INVALID,violation.getMessage());
            }
        }
        return true;
    }

}
