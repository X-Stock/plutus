package com.xstock.plutus;

import com.xstock.plutus.api.v1.stock.company.Company;
import com.xstock.plutus.api.v1.stock.company.CompanyController;
import com.xstock.plutus.api.v1.stock.company.CompanyService;
import com.xstock.plutus.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CompanyController.class, WebSecurityConfig.class})
class SecurityTests {
    private static final String url = "/api/v1";

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CompanyService companyService;

    private RequestPostProcessor mockRemoteIp(String ipAddress) {
        return request -> {
            request.setRemoteAddr(ipAddress);
            return request;
        };
    }

    @Test
    @WithMockUser
    void test01ShouldReturnCompanyWhenAuthorized() throws Exception {
        Company mockCompany = Mockito.mock(Company.class);
        when(companyService.getByTicker("VVS")).thenReturn(mockCompany);

        mvc.perform(get(url + "/companies/VVS"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.ticker").value(mockCompany.getTicker()));
    }

    @Test
    void test02ShouldNotReturnWhenUnauthorized() throws Exception {
        mvc.perform(get(url + "/companies")
                .with(mockRemoteIp("192.168.0.1")))
                .andExpect(status().isUnauthorized());
    }

    @ParameterizedTest
    @ValueSource(strings = { "127.0.0.1", "::1"})
    void test03ShouldAllowAccessWithAllowedIps(String ipAddress) throws Exception {
        mvc.perform(get(url + "/companies")
                        .with(mockRemoteIp(ipAddress))).
                andExpect(status().isOk());
    }
}
