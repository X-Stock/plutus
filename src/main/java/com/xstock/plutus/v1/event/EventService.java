package com.xstock.plutus.v1.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    public String addNewEvent(Event event) {
        eventRepository.save(event);
        return "Saved event";
    }
}
