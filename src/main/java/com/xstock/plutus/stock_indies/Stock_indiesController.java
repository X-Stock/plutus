package com.xstock.plutus.stock_indies;

import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listing;
import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listingRepository;
import com.xstock.plutus.stock_indies.Stock_indies;
import com.xstock.plutus.stock_indies.Stock_indiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/stock_indies")
public class Stock_indiesController {
    @Autowired
    private Stock_indiesRepository stock_indiesRepository;

    @PostMapping(path="/company_subsidiaries_listing")
    public @ResponseBody String addStockIndies (@RequestParam String indice_name) {

        Stock_indies n = new Stock_indies();
        n.setIndice_name(indice_name);
        stock_indiesRepository.save(n);
        return "Saved";
    }
}
