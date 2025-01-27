package com.platform.configserver.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name = "PROPERTIES")
public class Property {

    @Id()
    @Column(name="id")
    private Long Id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "application")
    private String application;

    @Column(name = "profile")
    private String profile;

    @Column(name = "label")
    private String label;

    @Column(name = "property_key")
    private String propertyKey;

    @Column(name = "value")
    private String value;


}
