package com.platform.platform.producer.service.kafka.wrapper;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class EventHeader {
    String source;
    String eventId;
    String eventVersion;
    Map<String,String> additionalProperties = new HashMap<>();
}
