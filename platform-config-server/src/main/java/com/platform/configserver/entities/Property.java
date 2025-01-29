package com.platform.configserver.entities;

import jakarta.persistence.*;
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
    private Long id;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Column(name = "application")
    private String application;

    @Column(name = "profile")
    private String profile;

    @Column(name = "label")
    private String label;

    @Column(name = "prop_key")
    private String propertyKey;

    @Column(name = "value")
    private String value;


}
