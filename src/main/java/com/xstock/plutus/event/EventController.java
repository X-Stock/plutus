package com.xstock.plutus.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public Iterable<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping(path = "/add")
    public String addNewEvent(@RequestBody Event event) {
        return eventService.addNewEvent(event);
    }
}
