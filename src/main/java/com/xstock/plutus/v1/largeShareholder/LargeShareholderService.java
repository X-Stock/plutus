package com.xstock.plutus.v1.largeShareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LargeShareholderService {
    @Autowired
    private LargeShareholderRepository largeShareholderRepository;

    public Iterable<LargeShareholder> getLargeShareholders() {
        return largeShareholderRepository.findAll();
    }

    public String addNewLargeShareholders(LargeShareholder largeShareholder) {
        largeShareholderRepository.save(largeShareholder);
        return "Saved large shareholders";
    }
}
