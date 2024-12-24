package com.xstock.plutus.api.v1.analysis.intersectHistorical;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistorical;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "intersectedHistorical")
@Service
public class IntersectedHistoricalService {
    private final StockHistoricalService stockHistoricalService;

    private <T> List<IntersectedHistorical<T>> intersectHistorical(Map<String, List<T>> historical) {
        Set<Instant> intersectTime = historical.values().parallelStream()
                .map(stockHistorical -> stockHistorical
                        .stream()
                        .map(item -> switch(item) {
                            case StockHistorical s -> s.getTime();
                            case StockHistoricalReturns sr -> sr.getTime();
                            default -> throw new IllegalStateException("Unexpected value: " + item);
                        })
                        .collect(Collectors.toSet()))
                .reduce((set1, set2) -> {
                    set1.retainAll(set2);
                    return set1;
                })
                .orElseGet(HashSet::new);

        return historical.entrySet()
                .parallelStream()
                .map(entry ->
                        new IntersectedHistorical<>(
                                entry.getKey(),
                                entry.getValue().parallelStream()
                                        .filter(item -> {
                                            Instant time = switch(item) {
                                                case StockHistorical s -> s.getTime();
                                                case StockHistoricalReturns sr -> sr.getTime();
                                                default -> throw new IllegalStateException("Unexpected value: " + item);
                                            };
                                            return intersectTime.contains(time);
                                        })
                                        .toList()
                        ))
                .toList();
    }

    @Cacheable
    public List<IntersectedHistorical<StockHistoricalReturns>> intersectHistoricalReturns(
            Set<String> tickers,
            String interval,
            Instant fromDate,
            Instant toDate
    ) {
        Map<String, List<StockHistoricalReturns>> historical = tickers
                .parallelStream()
                .collect(Collectors.toMap(
                        ticker -> ticker,
                        ticker -> stockHistoricalService
                                .getReturnsByTicker(ticker, interval, fromDate, toDate, null, true)
                                .content()
                ));

        return intersectHistorical(historical);
    }

    @Cacheable
    public List<IntersectedHistorical<StockHistorical>> intersectHistoricalPrices(
            Set<String> tickers,
            Instant fromDate,
            Instant toDate
    ) {
        Map<String, List<StockHistorical>> historical = tickers
                .parallelStream()
                .collect(Collectors.toMap(
                        ticker -> ticker,
                        ticker -> stockHistoricalService
                                .getAllByTicker(ticker, fromDate, toDate, null, true)
                                .content()
                ));

        return intersectHistorical(historical);
    }
}
