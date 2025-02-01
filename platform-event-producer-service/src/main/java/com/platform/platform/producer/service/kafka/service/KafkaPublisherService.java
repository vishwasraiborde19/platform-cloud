package com.platform.platform.producer.service.kafka.service;

import com.platform.platform.producer.service.kafka.wrapper.Event;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaPublisherService {

    private final KafkaTemplate kafkaTemplate;

    KafkaPublisherService(KafkaTemplate kafkaTemplate){
      this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message){
        kafkaTemplate.send(topic, message);
    }


    public void sendToKafka(final Event data) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("someTopic","key",data);
    }

}
