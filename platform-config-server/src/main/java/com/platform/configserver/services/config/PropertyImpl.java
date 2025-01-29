package com.platform.configserver.services.config;

import com.platform.configserver.entities.Property;
import com.platform.configserver.repositories.PropertyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyImpl implements PropertyService {

    private final PropertyRepo propertyRepo;

    PropertyImpl(final PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public Property addProperty(Property prop) {
        return propertyRepo.save(prop);
    }

    @Override
    public Property removeProperty(Property prop) {
         propertyRepo.delete(prop);
         return prop;
    }

    @Override
    public List<Property> getAll() {
        return propertyRepo.findAll();
    }

}
