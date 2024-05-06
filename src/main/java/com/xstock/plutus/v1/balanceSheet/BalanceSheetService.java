package com.xstock.plutus.v1.balanceSheet;

import com.xstock.plutus.exception.EntityNotFoundException;
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
        return balanceSheet.orElseThrow(() -> new EntityNotFoundException("balance sheet by ticker " + ticker));
    }

    @Override
    public Iterable<BalanceSheet> getAll() {
        Iterable<BalanceSheet> balanceSheets = balanceSheetRepository.findAll();
        if (!balanceSheets.iterator().hasNext()) {
            throw new EntityNotFoundException("all balance sheets");
        }
        return balanceSheets;
    }
}
