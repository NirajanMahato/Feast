package com.example.feast.Service;

import com.example.feast.Entity.Event;
import com.example.feast.Pojo.EventPojo;
import com.sun.jdi.request.EventRequest;

import java.util.List;
import java.util.Optional;

public interface EventService {
    void saveEvent(EventPojo eventPojo);
    List<Event> getALl();

    Optional<Event> getById(Long id);
}
