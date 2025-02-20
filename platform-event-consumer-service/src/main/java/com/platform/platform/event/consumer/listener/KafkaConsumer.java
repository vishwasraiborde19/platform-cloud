package com.platform.platform.event.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void  consume(String message) {
        System.out.println("message = " + message);
    }
}
