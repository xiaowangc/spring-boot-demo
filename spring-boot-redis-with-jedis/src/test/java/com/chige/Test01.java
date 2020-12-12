package com.chige;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;


@SpringBootTest
public class Test01 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void test1(){
        // 操作string
        stringRedisTemplate.opsForValue().set("chige","handsomeaaa");
        String chige = stringRedisTemplate.opsForValue().get("chige");
        logger.info("值{}",chige);
        //操作list
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        listOperations.leftPush("list1","a","b");
        String a = listOperations.leftPop("list1");
        System.out.println("list列表弹出值："+a);
        //操作set
        SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
        setOperations.add("set1","1","2","3");
        String set1 = setOperations.pop("set1");
        System.out.println("set1 弹出的值为：" + set1);

        //操作hash
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put("hash1","hashKey","hashValue");
        String o = (String) hashOperations.get("hash1", "hashKey");
        System.out.println("hash1中hashKey对应的值为：" + o);

        //操作sorted set
        ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();
        zSetOperations.add("zsort","分数",90);
        Double score = zSetOperations.score("zsort", "分数");
        System.out.println("分数为：" + score);

    }
}
