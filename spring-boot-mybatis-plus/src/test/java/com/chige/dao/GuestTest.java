package com.chige.dao;

import com.chige.domain.Guest;
import com.chige.mapper1.GuestMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;

/**
 * @author wangyc
 * @date 2022/6/6
 */
@SpringBootTest
public class GuestTest {
    @Autowired
    private GuestMapper guestMapper;
    @Test
    public void test1() {
        Guest guest = guestMapper.selectById(1);
        System.out.println(guest.toString());
        Assertions.assertNotNull(guest);

    }
}

