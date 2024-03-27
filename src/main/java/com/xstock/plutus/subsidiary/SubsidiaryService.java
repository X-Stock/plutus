package com.xstock.plutus.subsidiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubsidiaryService {
    @Autowired
    private SubsidiaryRepository subsidiaryRepository;

    public Iterable<Subsidiary> getSubsidiaries() {
        return subsidiaryRepository.findAll();
    }

    public String addNewSubsidiary (Subsidiary subsidiary) {
        subsidiaryRepository.save(subsidiary);
        return "Saved subsidiary";
    }
}
