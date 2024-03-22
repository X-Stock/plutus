package com.xstock.plutus.insider_deal;

import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listing;
import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listingRepository;
import com.xstock.plutus.insider_deal.Insider_deal;
import com.xstock.plutus.insider_deal.Insider_dealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/insider_deal")
public class Insider_dealController {
    @Autowired
    private Insider_dealRepository insider_dealRepository;

    @PostMapping(path="/insider_deal")
    public @ResponseBody String addInsiderDeal (@RequestParam String deal_method
            , @RequestParam String deal_action, @RequestParam Integer deal_quantity,  @RequestParam Integer deal_price, @RequestParam Integer deal_ratio {

        Insider_deal n = new Insider_deal();
        n.setDeal_method(deal_method);
        n.setDeal_action(deal_action);
        n.setDeal_action(deal_quantity);
        n.setDeal_action(deal_price);
        n.setDeal_action(deal_ratio);
        insider_dealRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/insider_deal")
    public @ResponseBody Iterable<Insider_deal> getAllInsiderDeal() {
        // This returns a JSON or XML with the users
        return insider_dealRepository.findAll();
    }
}
