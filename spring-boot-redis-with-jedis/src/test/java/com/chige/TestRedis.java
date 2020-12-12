package com.chige;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class TestRedis {

//    @Autowired
//    private JedisPool jedisPool;

    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("192.168.43.84",6379);
//        jedis.set("key1","xiaown");
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));
        jedis.close();

        /** 使用 缓存池 来维护多个redis连接 */
        JedisPool jedisPool = new JedisPool("192.168.43.84");

        Jedis jedis1 = jedisPool.getResource();
        Jedis jedis2 = jedisPool.getResource();
        Map<String,String> map = new HashMap<>(16);
        // setnx 命令：当设置的key存在时，则设置失败，key不存在时则设置成功

        // jedis.expire(key,second) 命令 ： 为key设置过期时间second

        // ttl 命令: 查看key还剩多久过期

        /** 使用 hset 命令组*/
        map.put("0","yongchi");
        map.put("1","zeyong");
        map.put("2","xiaowang");
        map.put("xin","xinxin");
        jedis1.hset("wang",map);
        System.out.println(jedis2.hget("3","0"));
        System.out.println(jedis2.hget("wang","A"));


    }

    @Test
    public void testPipe(){
        Jedis jedis = new Jedis("192.168.43.84",6379);
        // 获取管道
        Pipeline pipelined = jedis.pipelined();
        pipelined.set("key1","10");
        for (int i = 1; i < 10; i++){
            pipelined.incrBy("key1",1);
        }
        pipelined.sync();
    }

    @Test
    public void testTran(){

    }

}
