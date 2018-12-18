package com.test.jas.ws.service;

import org.springframework.stereotype.Component;

import com.test.jas.ws.domain.Customer;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component(value = "customerService")
@WebService
public class CustomerService {

    @WebMethod
    public Customer getCustomerById(String id) {
        return new Customer(id, "TestCustomer");
    }
}