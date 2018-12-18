package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.CustomerFindRequest;
import com.test.beans.CustomerFindResponse;
import com.test.beans.Status;
import com.test.jax.ws.service.Customer;
import com.test.jax.ws.service.CustomerRequest;
import com.test.jax.ws.service.CustomerService;
import com.test.jax.ws.service.GetCustomerById;

@Service
public class CustomerDelegatingService {

	@Autowired
	private CustomerService customerService;

	public CustomerFindResponse findCustomerById(CustomerFindRequest request) {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setId(request.getId());
		GetCustomerById customerGetRequest = new GetCustomerById();
		customerGetRequest.setArg0(customerRequest);

		Customer customer = customerService.getCustomerById(customerGetRequest.getArg0());
		
		CustomerFindResponse response = new CustomerFindResponse(customer, Status.SUCCESS);
		return response;
	}
}
