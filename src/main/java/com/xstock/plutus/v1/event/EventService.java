package com.xstock.plutus.v1.event;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService implements MultiResponseService<Event> {
    private final EventRepository eventRepository;

    @Override
    public Iterable<Event> getAllByTicker(String ticker) {
        return eventRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }
}
