package com.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    // Configuration for Kafka topics can be added here
    // For example, you can define topic names, partitions, replication factors, etc.

     //Example:
     @Bean
     public NewTopic commonTopic() {
         return TopicBuilder.name("common-topic")
                            .partitions(1) // sets the number of partitions
                            .replicas(1) // sets the number of replicas
                            .build();
     }

    @Bean
    public NewTopic evenTopic() {
        return TopicBuilder.name("even-topic")
                           .partitions(1)
                           .replicas(1)
                           .build();
    }

    @Bean
    public NewTopic oddTopic() {
        return TopicBuilder.name("odd-topic")
                           .partitions(1)
                           .replicas(1)
                           .build();
    }
}
