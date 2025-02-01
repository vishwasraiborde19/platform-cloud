package com.platform.platform.producer.service.kafka;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "event.producer.kafka")
@Component
@Data
public class KafkaProperties {
    private String bootstrapServers;
    private String groupId;
    private String topic;
}
