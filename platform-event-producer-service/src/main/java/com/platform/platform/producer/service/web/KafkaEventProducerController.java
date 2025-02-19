package com.platform.platform.producer.service.web;

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
public class KafkaEventProducerController {

    private final KafkaPublisherService kafkaPublisherService;

    public KafkaEventProducerController(final KafkaPublisherService kafkaPublisherService) {
        this.kafkaPublisherService = kafkaPublisherService;
    }

    @PostMapping("/events")
    public String sendMessage(final String topicName,
                              final String key,
                              final Event<String> event) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<String, String>> future = kafkaPublisherService.sendToKafka(topicName, key, event);
        return future.get().toString();
    }

}
