package com.chige.springbootkafka.config;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangyc
 * @date 2022/1/11
 */

public class KafkaCallback implements Callback {
    private static final Logger log = LoggerFactory.getLogger(KafkaCallback.class);
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e != null){
            String topic = recordMetadata.topic();
            log.error("消息事件-{}，结果：推送失败，原因：{}", topic, e);
            e.printStackTrace();;
        }

    }
}
