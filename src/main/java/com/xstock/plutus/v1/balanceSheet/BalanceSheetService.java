package com.xstock.plutus.v1.balanceSheet;

import com.xstock.plutus.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.service.SingleResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BalanceSheetService implements SingleResponseService<BalanceSheet> {
    private final BalanceSheetRepository balanceSheetRepository;

    @Override
    public BalanceSheet getByTicker(String ticker) {
        Optional<BalanceSheet> balanceSheet = balanceSheetRepository.findByCompany_Ticker(ticker);
        return balanceSheet.orElseThrow(() -> new ResourceNotFoundException("balance sheet by ticker " + ticker));
    }

    @Override
    public Iterable<BalanceSheet> getAll() {
        Iterable<BalanceSheet> balanceSheets = balanceSheetRepository.findAll();
        if (!balanceSheets.iterator().hasNext()) {
            throw new ResourceNotFoundException("all balance sheets");
        }
        return balanceSheets;
    }
}
