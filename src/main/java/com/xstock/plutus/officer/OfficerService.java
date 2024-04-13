package com.xstock.plutus.officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {
    @Autowired
    private OfficerRepository officerRepository;

    public Iterable<Officer> getOfficers() {
        return officerRepository.findAll();
    }

    public String addNewOfficer(Officer officer) {
        officerRepository.save(officer);
        return "Saved officer";
    }
}
