package com.platform.platform.producer.service.kafka.wrapper;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Event <P>{
    P payload;
    String eventName;
    String eventType;
    String eventTime;
}
