package com.chige.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.jar.JarEntry;

/**
 *  Redis 管道
 */
public class TestRedisPipe {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.43.84",6739);
        // 获取管道
        Pipeline pipelined = jedis.pipelined();
        pipelined.set("key1","10");
        for (int i = 1; i < 10; i++){
            pipelined.incrBy("key1",1);
        }
        pipelined.sync();


    }
}
