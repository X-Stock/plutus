package com.xstock.plutus.v1.stockIntraday;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class StockIntradayService implements MultiResponseService<StockIntraday> {
    private final StockIntradayRepository stockIntradayRepository;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public Iterable<StockIntraday> getAllByTicker(String ticker) {
        Iterable<StockIntraday> stockIntradays = stockIntradayRepository.findAllByCompany_Ticker(ticker);
        if (!stockIntradays.iterator().hasNext()) {
            throw new EntityNotFoundException("intraday by " + ticker);
        }
        return stockIntradays;
    }

    @Override
    public Iterable<StockIntraday> getAll() {
        Iterable<StockIntraday> stockIntradays = stockIntradayRepository.findAll();
        if (!stockIntradays.iterator().hasNext()) {
            throw new EntityNotFoundException("all intraday");
        }
        return stockIntradays;
    }

    public void getIntraday(SseEmitter emitter, String ticker) {
        executorService.scheduleAtFixedRate(() -> {
            try {
                emitter.send(getAllByTicker(ticker));
            } catch (IOException e) {
                emitter.complete();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
