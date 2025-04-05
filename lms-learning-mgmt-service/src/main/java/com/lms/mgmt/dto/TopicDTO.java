package com.lms.mgmt.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class TopicDTO {
    private int topicId;
    private String topicName;
    private String topicDescription;
    private String topicImage;
    private String topicStatus ;
    private String link;
}
