package com.platform.configserver.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
