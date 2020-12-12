package com.chige.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *  利用Redis池
 */
public class TestRedisPool {

    private static JedisPoolConfig poolConfig = new JedisPoolConfig();

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool(poolConfig,"192.168.43.84");
        Jedis resource = jedisPool.getResource();
        resource.lpush("key3","a","b","c");
        for (int i = 0; i <= resource.llen("key3"); i++){
            System.out.println(resource.lpop("key3"));;
        }
        resource.close();
    }
}
