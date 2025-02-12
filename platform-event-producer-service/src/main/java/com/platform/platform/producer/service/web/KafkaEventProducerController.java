package com.platform.platform.producer.service.web;

import com.platform.platform.producer.service.kafka.service.KafkaPublisherService;
import com.platform.platform.producer.service.kafka.wrapper.Event;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1")
public class KafkaEventProducerController {

    private final KafkaPublisherService kafkaPublisherService;

    public KafkaEventProducerController(final KafkaPublisherService kafkaPublisherService) {
        this.kafkaPublisherService = kafkaPublisherService;
    }

    @PostMapping("/events")
    public String sendMessage(String topicName, String key, Event<String> event) {
        CompletableFuture<SendResult<String, String>> future = kafkaPublisherService.sendToKafka(topicName, key, event);
        return future.toString();
    }
}
