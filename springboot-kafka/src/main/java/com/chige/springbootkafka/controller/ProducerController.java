package com.chige.springbootkafka.controller;

import com.chige.springbootkafka.domain.MessageEntity;
import com.chige.springbootkafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProducerController {
    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/kafka/send1")
    public String testProducer(@RequestBody MessageEntity message){
        kafkaProducer.send(message);
        return "ok";
    }

}
