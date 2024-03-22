package com.xstock.plutus.company_subsidiaries_listing;

import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listing;
import com.xstock.plutus.company_subsidiaries_listing.Company_subsidiaries_listingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/company_subsidiaries_listing")
public class Company_subsidiaries_listingController {
    @Autowired
    private Company_subsidiaries_listingRepository company_subsidiaries_listingRepository;

    @PostMapping(path="/company_subsidiaries_listing")
    public @ResponseBody String addCompanySubName (@RequestParam String company_id
            , @RequestParam String sub_company_name) {

        Company_subsidiaries_listing n = new Company_subsidiaries_listing();
        n.setCompany_id(company_id);
        n.setSub_company_name(sub_company_name);
        company_subsidiaries_listingRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/company_subsidiaries_listing")
    public @ResponseBody Iterable<Company_subsidiaries_listing> getAllCompanySubList() {
        // This returns a JSON or XML with the users
        return company_subsidiaries_listingRepository.findAll();
    }
}
