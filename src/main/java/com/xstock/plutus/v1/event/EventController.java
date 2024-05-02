package com.xstock.plutus.v1.event;

import com.xstock.plutus.utils.interfaces.controller.MultiResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class EventController implements MultiResponseController<Event> {
    private final EventService eventService;

    @Override
    @GetMapping(path = "/events")
    public Iterable<Event> getAllByTicker(@PathVariable String ticker) {
        return eventService.getAllByTicker(ticker);
    }
}
