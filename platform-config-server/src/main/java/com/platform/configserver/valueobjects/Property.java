package com.platform.configserver.valueobjects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Property {
    private Long id;
    private Date createdOn;
    private String application;
    private String profile;
    private String label;
    private String propertyKey;
    private String value;
}
