package com.xstock.plutus.v1.event;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService implements CommonService<Event> {
    private final EventRepository eventRepository;

    @Override
    public Iterable<Event> getAllByTicker(String ticker, Pageable pageable) {
        Page<Event> events = eventRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "notifyDate")))
        );
        if (events.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return events.getContent();
    }
}
