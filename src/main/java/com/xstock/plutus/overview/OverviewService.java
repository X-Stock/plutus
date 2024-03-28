package com.xstock.plutus.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverviewService {
    @Autowired
    private OverviewRepository overviewRepository;

    public Iterable<Overview> getOverviews() {
        return overviewRepository.findAll();
    }
}
