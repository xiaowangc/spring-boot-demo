package com.chige.springannotation.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangyc
 * @date 2022/3/10
 */
@Slf4j
@RestController
public class Controller {

    @PostMapping("/validation/notNull")
    public String notNullTest(@Valid @RequestBody Person person) {
        log.info(">>> Person={}", person);
        return "ok!";
    }
    @PostMapping("/validation/string/length")
    public String stringLength(@Valid @RequestBody Person person) {

        return "ok!";
    }

}
