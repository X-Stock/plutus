package com.xstock.plutus.api.v1.analysis.intersectHistorical;

import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistorical;
import com.xstock.plutus.api.v1.stock.stockHistorical.StockHistoricalReturns;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/intersect-historical")
public class IntersectedHistoricalController {
    private final IntersectedHistoricalService intersectedHistoricalService;

    @PostMapping
    public List<IntersectedHistorical<StockHistorical>> getIntersectedHistoricalPrice(
            @RequestBody @Valid IntersectHistoricalPricesRequest request
    ) {
        return intersectedHistoricalService.intersectHistoricalPrices(request);
    }

    @PostMapping(path = "/returns")
    public List<IntersectedHistorical<StockHistoricalReturns>> getIntersectedHistoricalReturns(
            @RequestBody @Valid IntersectHistoricalReturnsRequest request
    ) {
        return intersectedHistoricalService.intersectHistoricalReturns(request);
    }
}
