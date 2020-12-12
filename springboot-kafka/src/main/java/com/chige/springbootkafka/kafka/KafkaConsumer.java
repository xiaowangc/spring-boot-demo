package com.chige.springbootkafka.kafka;

import com.chige.springbootkafka.domain.MessageEntity;
import com.chige.springbootkafka.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Optional;

/** 消费者
 *
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = KafkaProducer.TOPIC_TEST)
    public void topic_test1(ConsumerRecord<?,?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Object value = record.value();
        log.info("使用对象接受："+value.toString());

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            String valueStr = (String) record.value();
            log.info("使用字符串接受："+valueStr);
            MessageEntity messageEntity = JacksonUtil.jsonToObject(valueStr, MessageEntity.class);
            String str = (String) message.get();
            MessageEntity messageEntity2 = JacksonUtil.jsonToObject(str, MessageEntity.class);
            log.info("2"+messageEntity2);
            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + valueStr + ",text:" + messageEntity);
        }

    }
    @KafkaListener(topics = KafkaProducer.TOPIC_TEST2)
    public void topic_test2(ConsumerRecord<?,?> record,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test2 消费了： Topic:" + topic + ",Message:" + msg);
        }
    }

    /** 消息转发
     *  只要一个SendTo注解即可实现消息转发
     * @param record 从TOPIC_TEST主题中拉取消息
     * @return String 经过处理后的消息再发送到TOPIC_TEST2主题中去
     */
    @KafkaListener(topics = KafkaProducer.TOPIC_TEST2)
    @SendTo(KafkaProducer.TOPIC_TEST2)
    public String onMessageForwardTo(ConsumerRecord<?, ?> record){
        //.....此处处理从主题拉取到的消息...
        return record.value() + "forward Message";
    }

}
