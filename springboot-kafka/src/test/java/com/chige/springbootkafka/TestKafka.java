package com.chige.springbootkafka;

import com.chige.springbootkafka.controller.ProducerController;
import com.chige.springbootkafka.domain.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class TestKafka {

    @Autowired
    private ProducerController controller;

    @Test
    public void test(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage("這是一個測試");
        String s = controller.testProducer(messageEntity);
        log.info(s);
    }

}
