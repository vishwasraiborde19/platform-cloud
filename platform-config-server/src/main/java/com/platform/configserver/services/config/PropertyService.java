package com.platform.configserver.services.config;

import com.platform.configserver.entities.Property;

import java.util.List;

public interface PropertyService {

    Property addProperty(Property prop);

    Property removeProperty(Property prop);

    List<Property> getAll();

    void delete(Long id);
}
