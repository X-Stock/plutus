package com.xstock.plutus.v1.officer;

import com.xstock.plutus.exception.EntityNotFoundException;
import com.xstock.plutus.utils.interfaces.service.MultiResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OfficerService implements MultiResponseService<Officer> {
    private final OfficerRepository officerRepository;

    @Override
    public Iterable<Officer> getAllByTicker(String ticker) {
        Iterable<Officer> officers = officerRepository.findAllByCompany_Ticker(ticker);
        if (!officers.iterator().hasNext()) {
            throw new EntityNotFoundException("officers by " + ticker);
        }
        return officers;
    }

    @Override
    public Iterable<Officer> getAll() {
        Iterable<Officer> officers = officerRepository.findAll();
        if (!officers.iterator().hasNext()) {
            throw new EntityNotFoundException("all officers");
        }
        return officers;
    }
}
