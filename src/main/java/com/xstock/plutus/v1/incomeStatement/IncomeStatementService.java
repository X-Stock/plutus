package com.xstock.plutus.v1.incomeStatement;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import com.xstock.plutus.utils.interfaces.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IncomeStatementService implements CommonService<IncomeStatement> {
    private final IncomeStatementRepository incomeStatementRepository;

    @Override
    public List<IncomeStatement> getAllByTicker(String ticker, Pageable pageable) {
        Page<IncomeStatement> incomeStatements = incomeStatementRepository.findAllByCompany_Ticker(ticker,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "quarter", "year")))
        );
        if (incomeStatements.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return incomeStatements.getContent();
    }
}
