package com.xstock.plutus.v1.cashflow;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CashFlowService implements SingleResponseService<CashFlow> {
    private final CashFlowRepository cashFlowRepository;

    @Override
    public CashFlow getByTicker(String ticker) {
        Optional<CashFlow> cashFlow = cashFlowRepository.findByCompany_Ticker(ticker);
        return cashFlow.orElseThrow(() -> new EntityNotFoundException("cash flow by " + ticker));
    }

    @Override
    public Iterable<CashFlow> getAll() {
        Iterable<CashFlow> cashFlows = cashFlowRepository.findAll();
        if (!cashFlows.iterator().hasNext()) {
            throw new EntityNotFoundException("all cash flows" );
        }
        return cashFlows;
    }
}
