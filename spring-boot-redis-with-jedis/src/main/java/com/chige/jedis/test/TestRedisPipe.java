package com.chige.jedis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 *  Redis 管道
 */
public class TestRedisPipe {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.103.9.134",6739);
        // 获取管道
        Pipeline pipelined = jedis.pipelined();
        pipelined.set("key1","10");
        for (int i = 1; i < 10; i++){
            pipelined.incrBy("key1",1);
        }
        pipelined.sync();


    }
}
