package com.chige;

import cn.hutool.json.JSONUtil;
import com.chige.redistemplate.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

@Slf4j
@CacheConfig(cacheNames = {"user"})
@SpringBootTest(classes = Application.class)
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    @CachePut
    public void testStringType() {
        // 字符串类型组件
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        ValueOperations<String, String> strOps = stringRedisTemplate.opsForValue();
        String key = "key1";
        String values = "1";
        valueOperations.set(key,new User("AA","123456",1));
        String key2 = "key2";
        strOps.set(key2,JSONUtil.toJsonStr(new User("BB","123654",2)));
        Object o = valueOperations.get(key);
        String s = strOps.get(key2);
        if (o != null) {
            log.info("获取key值：{}",valueOperations.get(key));
        }else {
            log.info("无法获取到值");
        }
        if (StringUtils.isNotBlank(s)) {
            log.info("获取key2的值：{}",s);
        }
    }

    /**
     *  列表类型特性：有序，可重复
     */
    @Test
    public void testListType() throws JsonProcessingException {
        // 列表类型操作组件
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        List<User> userList = new ArrayList<>();
        userList.add(new User("A","13672",1));
        userList.add(new User("B","13671",2));
        userList.add(new User("C","13670",3));
        final String key = "redis:list:1";
        log.info("构建已经排好序的用户对象列表，{}", JSONUtil.toJsonStr(userList));
        // 想redis数据库中新增数据-从尾部插入
        for (User user : userList) {
            opsForList.leftPush(key,user);
        }
        // 从redis数据库中拿取数据，从头部获取
        Object o = opsForList.rightPop(key);
        while (o != null) {
            User user = (User) o;
            log.info("获取到的用户为：{}", user.toString());
            o = opsForList.rightPop(key);
        }

    }

    @Test
    public void testSetType() {
        // set集合类型操作组价
        SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();

    }
    @Test
    public void testSortedSetType() {
        // 有序SortedSet集合操作组件
        ZSetOperations<String, Object> opsForZSet = redisTemplate.opsForZSet();

    }

    @Test
    public void testHashType() {
        // Hash哈希存储类型操作组件
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();

    }


}
