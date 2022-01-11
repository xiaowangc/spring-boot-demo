package com.chige.listDemo.service;

import com.chige.openfeign.config.RedisKeyConfig;
import com.chige.domain.RedPacketRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class RedpacketService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 生成随机红包的方法
     */
    public Integer[] randomRed(Integer total,Integer count) {
        int use = 0;
        Integer[] array = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                array[i] = total - use;
            }else{
                int avg = (total - use) * 2 / (count - i);
                array[i] = 1 + random.nextInt(avg - 1);
            }
            use = use + array[i];
        }
        return array;
    }

    /**
     *  生成随机红包，并放入缓存列表
     */
    public long setPacket(RedPacketRequest redPacketRequest) {
        // 生成随机红包
        Integer[] randomRed = this.randomRed(redPacketRequest.getMoney(), redPacketRequest.getNum());
        // 自增id
        long id = this.incrementId();
        String key = RedisKeyConfig.RANDOM_PACKET_LIST + id;
        // 将随机红包存储缓存列表
        ListOperations<String, Object> opsForList = this.redisTemplate.opsForList();
        opsForList.leftPush(key, randomRed);
        // 设置红包的过期时间
        this.redisTemplate.expire(key,3, TimeUnit.DAYS);
        log.info("拆解红包{}={}",key,randomRed);
        return id;
    }

    /**
     * 通过userId抢红包
     */
    public Integer getOneRed(long redId,long userId) {
        // 通过红包id获取红包对象
        Object o = this.redisTemplate.opsForHash().get(RedisKeyConfig.RED_PACKET_CONSUME_KEY + redId, String.valueOf(userId));
        if (o == null) {
            // 该userId可以抢红包
            Object o1 = this.redisTemplate.opsForList().leftPop(RedisKeyConfig.RANDOM_PACKET_LIST + redId);
            if (o1 != null) {
                this.redisTemplate.opsForHash().put(RedisKeyConfig.RED_PACKET_CONSUME_KEY+redId,userId,userId);
                log.info("用户{}抢到了红包：{}元",userId,o1);
                //TODO  异步将用户抢到红包的记录写入DB中
                return Integer.parseInt(o1+"");
            }
            return -1;//红包被抢完了
        }
        return -2; // 抢过红包了
    }


    private long incrementId() {
        long id = this.redisTemplate.opsForValue().increment(RedisKeyConfig.ID_KEY);
        return id;
    }
}
