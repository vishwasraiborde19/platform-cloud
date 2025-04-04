package com.lms.mgm.mapper;

import org.springframework.beans.BeanUtils;

public class GenericMapper <Entity, ValueObject>{
    Entity entity;
    ValueObject valueObject;

    public GenericMapper(Entity entity, ValueObject valueObject) {
        this.entity = entity;
    }


    public Entity mapValueToEntity(ValueObject valueObject, Entity entity) {
        BeanUtils.copyProperties(valueObject, entity);
        return entity;
    }

    public ValueObject mapEntityToValueObject(Entity entity, ValueObject valueObject) {
        BeanUtils.copyProperties(entity, valueObject);
        return valueObject;
    }
}
