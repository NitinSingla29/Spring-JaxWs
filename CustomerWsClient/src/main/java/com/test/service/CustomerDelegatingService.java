package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.CustomerFindRequest;
import com.test.dto.CustomerFindResponse;
import com.test.dto.Status;
import com.test.jax.ws.service.Customer;
import com.test.jax.ws.service.CustomerRequest;
import com.test.jax.ws.service.CustomerService;

@Service
public class CustomerDelegatingService {

	@Autowired
	private CustomerService customerService;

	public CustomerFindResponse findCustomerById(CustomerFindRequest request) {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setId(request.getId());

		Customer customer = customerService.getCustomerById(customerRequest);
		
		CustomerFindResponse response = new CustomerFindResponse(customer, Status.SUCCESS);
		return response;
	}
}
