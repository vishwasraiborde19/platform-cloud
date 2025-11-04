package com.platform.platform.producer.service.kafka.service;

import com.platform.platform.producer.service.kafka.wrapper.Event;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log
public class KafkaPublisherService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaPublisherService.class);

    private final KafkaTemplate<String,String> kafkaTemplate;

    KafkaPublisherService(KafkaTemplate<String,String> kafkaTemplate){
      this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message){
        kafkaTemplate.send(topic, message);
    }


    public CompletableFuture<SendResult<String, String>> sendToKafka(final String topicName , String key , final Event data) {
        return kafkaTemplate.send(topicName,key,data.toString());
    }

}
