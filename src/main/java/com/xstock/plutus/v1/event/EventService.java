package com.xstock.plutus.v1.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    public Iterable<Event> getAllByTicker(String ticker) {
        return eventRepository.findAllByCompany_Ticker(ticker);
    }
}
