package com.chige.docker.redis;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wangyc
 * @date 2022/6/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        ValueOperations<String, Object> stringValueOperations = redisTemplate.opsForValue();
        Object testKey1 = stringValueOperations.get("testKey1");
        Assertions.assertNotNull(testKey1);

    }
}
