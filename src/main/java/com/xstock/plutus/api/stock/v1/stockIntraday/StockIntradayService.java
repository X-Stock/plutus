package com.xstock.plutus.api.stock.v1.stockIntraday;

import com.xstock.plutus.utils.dto.PaginatedResponse;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.SimpleAsyncTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@Service
public class StockIntradayService implements CommonService<StockIntraday> {
    private final StockIntradayRepository stockIntradayRepository;
    private final TaskScheduler taskScheduler = new SimpleAsyncTaskScheduler();

    @Override
    public PaginatedResponse<StockIntraday> getAllByTicker(String ticker, Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<StockIntraday> stockIntradays = stockIntradayRepository.findAllByCompanyTicker(ticker, paging);
        if (stockIntradays.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new PaginatedResponse<>(stockIntradays.getTotalPages(), stockIntradays.getContent());
    }

    public SseEmitter getIntraday(String ticker, Pageable pageable, boolean unpaged) {
        Pageable paging = unpaged
                ? Pageable.unpaged()
                : pageable;

        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        var intraday = getAllByTicker(ticker, paging, unpaged);
        var scheduledFuture = taskScheduler.scheduleAtFixedRate(() -> {
            try {
                emitter.send(intraday);
            } catch (IOException e) {
                emitter.complete();
            }
        }, Instant.now(), Duration.ofSeconds(1));
        emitter.onCompletion(() -> scheduledFuture.cancel(true));
        return emitter;
    }
}
