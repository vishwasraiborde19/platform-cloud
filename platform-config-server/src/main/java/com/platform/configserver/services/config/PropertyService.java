package com.platform.configserver.services.config;

import com.platform.configserver.dto.AdminDtos.ApplicationSummary;
import com.platform.configserver.dto.AdminDtos.PropertyRequest;
import com.platform.configserver.entities.Property;

import java.util.List;

public interface PropertyService {

    List<Property> getAll();

    List<Property> find(String application, String profile, String label);

    List<ApplicationSummary> applications();

    Property create(PropertyRequest request);

    Property update(Long id, PropertyRequest request);

    void delete(Long id);

    Property getById(Long id);
}
