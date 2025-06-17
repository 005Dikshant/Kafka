package com.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    // Configuration for Kafka consumer can be added here
    // For example, you can define Kafka consumer properties, listener containers, etc.

     @Bean
     public ConsumerFactory<String, String> consumerFactory() {
         Map<String, Object> props = new HashMap<>();
         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // kafka server address
         props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group"); // consumer group ID
         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // start reading from the earliest message
         return new DefaultKafkaConsumerFactory<>(props);
     }
     @Bean
     public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
         ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
         factory.setConsumerFactory(consumerFactory());
         return factory;
     }
}
