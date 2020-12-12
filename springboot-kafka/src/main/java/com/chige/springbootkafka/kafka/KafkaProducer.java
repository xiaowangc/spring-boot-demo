package com.chige.springbootkafka.kafka;

import com.chige.springbootkafka.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/** 生产者
 *
 */
@Component
@Slf4j
public class KafkaProducer {

    public static final String TOPIC_TEST2 = "topic.test2";
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    // 自定义topic
    public static final String TOPIC_TEST = "topic.test";
    // 消费者组1
    public static final String TOPIC_GROUP1 = "topic.group1";
    // 消费者组2
    public static final String TOPIC_GROUP2 = "topic.group2";

    public void send(Object obj) {
        String obj2String = JacksonUtil.objectToString(obj);
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
        kafkaTemplate.send(TOPIC_TEST, obj2String).addCallback(success -> {
            assert success != null;
            String topic = success.getRecordMetadata().topic();
            int partition = success.getRecordMetadata().partition();
            long offset = success.getRecordMetadata().offset();
            //成功的处理
            log.info(TOPIC_TEST + " - 生产者 发送消息成功：主題為:" + topic + "消息發送到的分區："
                    + partition + "消息在分區內的offset為：" + offset);
        },failure -> {
            //发送失败的处理
            log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + failure.getMessage());
        });
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST,obj2String);
//        // 回调消息
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
//
//            }
//        });
    }



}
