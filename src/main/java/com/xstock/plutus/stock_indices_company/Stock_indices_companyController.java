package com.xstock.plutus.stock_indices_company;

import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listing;
import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listingRepository;
import com.xstock.plutus.stock_indices_company.Stock_indices_company;
import com.xstock.plutus.stock_indices_company.Stock_indices_companyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/stock_indices_company")
public class Stock_indices_companyController {
    @Autowired
    private Stock_indices_companyRepository stock_indices_companyRepository;

    @PostMapping(path="/stock_indices_company")
    public @ResponseBody String addStockIndicesId (@RequestParam Integer stock_indices_id) {

        Stock_indices_company n = new Stock_indices_company();
        n.setStock_indices_id(stock_indices_id);
        stock_indices_companyRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/stock_indices_company")
    public @ResponseBody Iterable<Stock_indices_company> getAllStockIndicesId() {
        // This returns a JSON or XML with the users
        return stock_indices_companyRepository.findAll();
    }
}
