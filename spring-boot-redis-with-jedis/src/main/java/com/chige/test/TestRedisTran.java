package com.chige.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 *  Redis 事务
 */
public class TestRedisTran {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.43.84",6379);

        jedis.set("w1","2000");
        jedis.set("w2","3000");
        jedis.watch("w1","w2");
        long l = 1000;
        if (Integer.parseInt(jedis.get("w1")) >= l){
            // redis事务 使用multi
            Transaction multi = jedis.multi();
            multi.decrBy("w1",l);
            multi.incrBy("w2",l);
            multi.exec();
        }
        List<String> mget = jedis.mget("w1", "w2");
        System.out.println(mget);

    }

}
