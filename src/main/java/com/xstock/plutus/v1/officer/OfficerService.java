package com.xstock.plutus.v1.officer;

import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OfficerService implements MultiResponseService<Officer> {
    private final OfficerRepository officerRepository;

    @Override
    public Iterable<Officer> getAllByTicker(String ticker) {
        return officerRepository.findAllByCompany_Ticker(ticker);
    }

    @Override
    public Iterable<Officer> getAll() {
        return officerRepository.findAll();
    }
}
