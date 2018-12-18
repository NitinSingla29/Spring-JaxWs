package com.test.jax.ws.service;

import com.test.jax.ws.domain.Customer;
import com.test.jax.ws.dto.CustomerRequest;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component(value = "customerService")
@WebService
public class CustomerService {

    @WebMethod
    public Customer getCustomerById(CustomerRequest customerRequest) {
        return new Customer(customerRequest.getId(), "TestCustomer");
    }
}