package com.platform.platform.producer.service.web;

import com.platform.platform.producer.service.kafka.service.KafkaAsyncPublisherService;
import com.platform.platform.producer.service.kafka.service.KafkaPublisherService;
import com.platform.platform.producer.service.kafka.wrapper.Event;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
public class KafkaAsynEventProducerController {

    private final KafkaAsyncPublisherService kafkaAsyncPublisherService;

    public KafkaAsynEventProducerController(final KafkaAsyncPublisherService kafkaAsyncPublisherService) {
        this.kafkaAsyncPublisherService = kafkaAsyncPublisherService;
    }

    @PostMapping("/events/async")
    public void sendMessage(final String topicName,
                              final String key,
                              final Event<String> event) throws ExecutionException, InterruptedException {
        kafkaAsyncPublisherService.sendToKafka(topicName, key, event);
    }

}
