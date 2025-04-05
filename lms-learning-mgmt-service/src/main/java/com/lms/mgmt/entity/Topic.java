package com.lms.mgmt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "topic_tbl")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int topicId;
    private String topicName;
    private String topicDescription;
    private String topicImage;
    private String topicStatus ;
    private String link;
}
