package com.platform.platform.event.consumer.persistence.api;

public interface GenericPersistenceApi<Event> {

    void save(Event event);
    void update(Event event);
    void delete(Event event);
}
