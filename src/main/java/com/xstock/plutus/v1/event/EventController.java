package com.xstock.plutus.v1.event;

import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies/{ticker}")
public class EventController implements CommonController<Event> {
    private final EventService eventService;

    @Override
    @GetMapping(path = "/events")
    public List<Event> getAllByTicker(@PathVariable String ticker, Pageable pageable) {
        return eventService.getAllByTicker(ticker, pageable);
    }
}
