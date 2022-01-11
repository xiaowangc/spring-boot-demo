package com.chige.springbootkafka.kafka;

import com.chige.springbootkafka.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/** 生产者
 *
 */
@Component
@Slf4j
public class KafkaProducer {

    public static final String TOPIC_TEST2 = "topic.test2";
    private final KafkaTemplate<String,Object> kafkaTemplate;
    // 自定义topic
    public static final String TOPIC_TEST = "topic.test";
    // 消费者组1
    public static final String TOPIC_GROUP1 = "topic.group1";
    // 消费者组2
    public static final String TOPIC_GROUP2 = "topic.group2";

    @Autowired
    public KafkaProducer(KafkaTemplate<String,Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     *  生产者发送的几种方式：
     *  1、简单发送
     *  2、同步发送，处理推送同步结果
     *  3、异步发送，新建回调对象
     */
    public void send(Object obj) {
        String obj2String = JacksonUtil.objectToString(obj);
        log.info("准备发送消息为：{}", obj2String);
        // 1、简单发送
//        kafkaTemplate.send(TOPIC_TEST, obj2String);
        // 2、同步发送
        try {
            SendResult<String, Object> sendResult = kafkaTemplate.send(TOPIC_TEST, obj2String).get();
            ProducerRecord<String, Object> producerRecord = sendResult.getProducerRecord();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 3、异步发送:处理方式一
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST,obj2String);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {

            }
        });
        //3、异步发送:处理方式二
        kafkaTemplate.send(TOPIC_TEST, obj2String).addCallback(success -> {
            assert success != null;
            String topic = success.getRecordMetadata().topic();
            int partition = success.getRecordMetadata().partition();
            long offset = success.getRecordMetadata().offset();
            //成功的处理
            log.info(TOPIC_TEST + " - 生产者发送消息成功：主题为:" + topic + "消息发送到的分区："
                    + partition + "消息在分区内的offset为：" + offset);
        },failure -> {
            //发送失败的处理
            log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + failure.getMessage());
        });

    }

}
