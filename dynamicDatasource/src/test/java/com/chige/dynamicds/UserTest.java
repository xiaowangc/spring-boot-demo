package com.chige.dynamicds;

import com.chige.dynamicds.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@SpringBootTest
public class UserTest {

    UserService userService;

    @Autowired
    public UserTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void test() {
        System.out.println(userService.getCount());
        System.out.println(userService.slave());
    }
}
