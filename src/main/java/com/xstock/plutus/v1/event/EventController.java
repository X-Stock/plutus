package com.xstock.plutus.v1.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping(path = "/events")
    public Iterable<Event> getByTicker(@PathVariable String ticker) {
        return eventService.getAllByTicker(ticker);
    }
}
