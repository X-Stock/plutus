package com.xstock.plutus.api.v1.stock.event;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.interfaces.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class EventController implements CommonController<Event> {
    private final EventService eventService;

    @Override
    @GetMapping(path = "/companies/{ticker}/events")
    public PaginatedResponse<Event> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        return eventService.getAllByTicker(ticker, pageable, unpaged);
    }

    @GetMapping(path = "/events")
    public PaginatedResponse<Event> getAll(Pageable pageable, boolean unpaged) {
        return eventService.getAll(pageable, unpaged);
    }
}
