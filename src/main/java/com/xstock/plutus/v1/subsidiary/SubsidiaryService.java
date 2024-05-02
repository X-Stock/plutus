package com.xstock.plutus.v1.subsidiary;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubsidiaryService implements MultiResponseService<Subsidiary> {
    private final SubsidiaryRepository subsidiaryRepository;

    @Override
    public final Iterable<Subsidiary> getAllByTicker(String ticker) {
        return subsidiaryRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public final Iterable<Subsidiary> getAll() {
        return subsidiaryRepository.findAll();
    }
}
