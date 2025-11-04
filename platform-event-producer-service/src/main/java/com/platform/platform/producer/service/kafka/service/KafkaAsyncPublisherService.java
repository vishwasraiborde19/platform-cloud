package com.platform.platform.producer.service.kafka.service;

import com.platform.platform.producer.service.kafka.wrapper.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.Executor;

@Service
public class KafkaAsyncPublisherService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final Executor taskExecutor;

    KafkaAsyncPublisherService(final KafkaTemplate<String,String> kafkaTemplate,
                               @Qualifier("asyncExecutor") final Executor taskExecutor){
        this.kafkaTemplate = kafkaTemplate;
        this.taskExecutor = taskExecutor;
    }



    public void sendToKafka(final String topicName , String key , final Event data) {
        taskExecutor.execute(() -> {
            kafkaTemplate.send(topicName,key,data.toString());
        });
    }

}
