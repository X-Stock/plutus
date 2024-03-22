package com.xstock.plutus.stock_historical_data;


import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listing;
import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listingRepository;
import com.xstock.plutus.stock_historical_data.Stock_historical_data;
import com.xstock.plutus.stock_historical_data.Stock_historical_dataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/stock_historical_data")
public class Stock_historical_dataController {
    @Autowired
    private Stock_historical_dataRepository stock_historical_dataRepository;

    @PostMapping(path="/stock_historical_data")
    public @ResponseBody String addStockHistoricalData (@RequestParam Integer open
            , @RequestParam Integer close, @RequestParam Integer high, @RequestParam Integer low, @RequestParam Integer volume) {

        Stock_historical_data n = new Stock_historical_data();
        n.setOpen(open);
        n.setClose(close);
        n.setHigh(high);
        n.setLow(low);
        n.setVolume(volume);
        stock_historical_dataRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/stock_historical_data")
    public @ResponseBody Iterable<Stock_historical_data> getAllStockHistoricalData() {
        // This returns a JSON or XML with the users
        return stock_historical_dataRepository.findAll();
    }
}
