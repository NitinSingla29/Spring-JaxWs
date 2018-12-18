package com.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;
import com.test.beans.CustomerFindResponse;
import com.test.beans.Status;
import com.test.controller.CustomerController;
import com.test.jax.ws.service.Customer;
import com.test.service.CustomerDelegatingService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerDelegatingService service;

	@Test
	public void testForValidCustomerId() throws Exception {
		String requestBody = "{\"id\": \"1\"}";
		
		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("TestCustomer");
		when(service.findCustomerById(any())).thenReturn(new CustomerFindResponse(customer, Status.SUCCESS));

		mvc.perform(MockMvcRequestBuilders.post("/customer").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("customer.id").value("1"))
				.andExpect(MockMvcResultMatchers.jsonPath("customer.name").value("TestCustomer"));
	}

	@Test
	public void mockException() throws Exception {
		String requestBody = "{\"id\": \"\"}";

		mvc.perform(MockMvcRequestBuilders.post("/customer").content(requestBody)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
	}

}
