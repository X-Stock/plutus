package com.xstock.plutus.v1.stockIntraday;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.SimpleAsyncTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@Service
public class StockIntradayService implements MultiResponseService<StockIntraday> {
    private final StockIntradayRepository stockIntradayRepository;
    private final TaskScheduler taskScheduler = new SimpleAsyncTaskScheduler();

    @Override
    public Iterable<StockIntraday> getAllByTicker(String ticker) {
        Iterable<StockIntraday> stockIntradays = stockIntradayRepository.findAllByCompany_Ticker(ticker);
        if (!stockIntradays.iterator().hasNext()) {
            throw new ResourceNotFoundException("intraday by " + ticker);
        }
        return stockIntradays;
    }

    @Override
    public Iterable<StockIntraday> getAll() {
        Iterable<StockIntraday> stockIntradays = stockIntradayRepository.findAll();
        if (!stockIntradays.iterator().hasNext()) {
            throw new ResourceNotFoundException("all intraday");
        }
        return stockIntradays;
    }

    public SseEmitter getIntraday(String ticker) {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        var intraday = getAllByTicker(ticker);
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
