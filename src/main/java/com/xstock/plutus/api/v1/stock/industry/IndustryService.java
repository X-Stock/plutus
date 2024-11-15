package com.xstock.plutus.api.v1.stock.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "industries")
public class IndustryService {
    private final IndustryInterface industryInterface;

    private final ObjectMapper objectMapper;

    public IndustryService(IndustryInterface industryInterface, ObjectMapper objectMapper) {
        this.industryInterface = industryInterface;
        this.objectMapper = objectMapper.copy().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    @Cacheable
    public Iterable<Industry> geIndustryWithTickers() {
        Iterable<Object[]> results = industryInterface.findIndustryWithCompanies();

        if (!results.iterator().hasNext()) {
            throw new ResourceNotFoundException();
        }

        List<Industry> industries = new ArrayList<>();
        for (Object[] row : results) {
            String industry = (String) row[0];
            String companiesJson = (String) row[1]; // JSON as a String
            try {
                List<Company> companies = objectMapper.readValue(
                        companiesJson,
                        new TypeReference<>() {}
                );
                industries.add(new Industry(industry, companies));
            } catch (Exception e) {
                throw new RuntimeException("Error parsing companies JSON", e);
            }
        }
        return industries;
    }
}
