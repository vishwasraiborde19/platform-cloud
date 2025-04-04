package com.common.model.topic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class TopicDTO {
    private int id;
    private int parentId;
    private String topicName;
    private String topicDescription;
    private Date createTime;
    private Date completionDate;
    private String topicContentReference;
}
