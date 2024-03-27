package com.xstock.plutus.largeShareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/largeShareholders")
public class LargeShareholderController {
    @Autowired
    private LargeShareholderService largeShareholderService;

    @GetMapping("/")
    public Iterable<LargeShareholder> getLargeShareholders() {
        return largeShareholderService.getLargeShareholders();
    }

    @PostMapping("/add")
    public String addNewLargeShareholders(@RequestBody LargeShareholder largeShareholder) {
        return largeShareholderService.addNewLargeShareholders(largeShareholder);
    }
}
