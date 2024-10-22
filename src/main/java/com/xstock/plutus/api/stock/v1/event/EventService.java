package com.xstock.plutus.api.stock.v1.event;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "events")
public class EventService implements CommonService<Event> {
    private final EventRepository eventRepository;

    @Override
    @Cacheable
    public PaginatedResponse<Event> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "notifyDate");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Event> events = eventRepository.findAllByCompanyTicker(ticker, paging);
        if (events.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(events.getTotalPages(), events.getContent());
    }
}
