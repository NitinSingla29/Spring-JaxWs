package com.test.dto;

import com.test.jax.ws.service.Customer;

public class CustomerFindResponse {
	
	private Customer customer;
	
	private Status status;

	public CustomerFindResponse() {
		super();
	}

	public CustomerFindResponse(Customer customer, Status status) {
		super();
		this.customer = customer;
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
