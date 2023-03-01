package com.chige.retry;

import com.chige.retry.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2023/3/1
 */

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testRetry() {
        System.out.println(userService.doMethod());
        System.out.println(userService.doMethod());
        System.out.println(userService.doMethod());
    }
}
