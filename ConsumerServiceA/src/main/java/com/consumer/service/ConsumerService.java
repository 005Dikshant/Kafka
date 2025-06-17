package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "common-topic", groupId = "my-consumer-group")
    public void consumeCommonTopicMessage(String message){
        // Logic to process the message from the common topic
        System.out.println("Received message from common topic: " + message);
    }

    @KafkaListener(topics = "even-topic", groupId = "my-consumer-group")
    public void consumeEvenTopicMessage(String message){
        // Logic to process the message from the even topic
        System.out.println("Received message from even-topic: " + message);
    }

    @KafkaListener(topics = "odd-topic", groupId = "my-consumer-group")
    public void consumeOddTopicMessage(String message){
        // Logic to process the message from the odd topic
        System.out.println("Received message from odd-topic: " + message);
    }
}
