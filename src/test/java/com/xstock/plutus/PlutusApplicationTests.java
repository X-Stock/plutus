package com.xstock.plutus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlutusApplicationTests {
	@Autowired
	private MockMvc mvc;

	private static final String url = "/api/v1";

	@Test
	void contextLoads() {
	}

	@Test
	@WithMockUser
	void shouldReturnCompaniesWhenAuthorized() throws Exception {
		this.mvc.perform(get(url + "/companies"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(9))
				.andExpect(jsonPath("$..ticker").value(hasItem("VVS")));
	}

	@Test
	void shouldNotReturnWhenUnauthorized() throws Exception {
		this.mvc.perform(get(url + "/companies"))
				.andExpect(status().isUnauthorized());
	}
}
