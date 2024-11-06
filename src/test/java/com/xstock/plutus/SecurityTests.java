package com.xstock.plutus;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.company.CompanyController;
import com.xstock.plutus.api.v1.stock.company.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisabledInAotMode
@WebMvcTest(CompanyController.class)
class SecurityTests {
    private static final String url = "/api/v1";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CompanyService companyService;

    @Test
    @WithMockUser
    void shouldReturnCompanyWhenAuthorized() throws Exception {
        Company mockCompany = Mockito.mock(Company.class);
        when(companyService.getByTicker("VVS")).thenReturn(mockCompany);

        mvc.perform(get(url + "/companies/VVS"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.ticker").value(mockCompany.getTicker()));
    }

    @Test
    void shouldNotReturnWhenUnauthorized() throws Exception {
        mvc.perform(get(url + "/companies"))
                .andExpect(status().isUnauthorized());
    }
}
