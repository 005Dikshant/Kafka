package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    // This service can be used to produce messages to Kafka topics
    // You can inject KafkaTemplate here and use it to send messages

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
     public void sendMessageToCommonTopics(String message) {
         kafkaTemplate.send("common-topic", message);
     }

     public void sendMessageToEvenTopic(String message) {
         kafkaTemplate.send("even-topic", message);
     }

     public void sendMessageToOddTopic(String message) {
         kafkaTemplate.send("odd-topic", message);
     }

    // Additional methods for producing messages can be added here
}
