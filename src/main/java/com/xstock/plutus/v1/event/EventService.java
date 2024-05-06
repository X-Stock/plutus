package com.xstock.plutus.v1.event;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService implements MultiResponseService<Event> {
    private final EventRepository eventRepository;

    @Override
    public Iterable<Event> getAllByTicker(String ticker) {
        Iterable<Event> events = eventRepository.findAllByCompany_Ticker(ticker);
        if (!events.iterator().hasNext()) {
            throw new EntityNotFoundException("events by " + ticker);
        }
        return events;
    }

    @Override
    public Iterable<Event> getAll() {
        Iterable<Event> events = eventRepository.findAll();
        if (!events.iterator().hasNext()) {
            throw new EntityNotFoundException("all events");
        }
        return events;
    }
}
