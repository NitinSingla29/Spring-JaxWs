package com.test.controller;

import com.test.dto.CustomerFindRequest;
import com.test.dto.CustomerFindResponse;
import com.test.dto.Status;
import com.test.exception.MissingCustomerIdException;
import com.test.service.CustomerDelegatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDelegatingService customerService;

    @PostMapping("/customer")
    ResponseEntity<?> findCustomer(@RequestBody CustomerFindRequest customerRequest) {
        String customerId = customerRequest.getId();
        if (customerId == null || customerId.trim().length()==0) {
            throw new MissingCustomerIdException("Customer id is missing");
        }
        CustomerFindResponse customerFindResponse = customerService.findCustomerById(customerRequest);
        customerFindResponse.setStatus(Status.SUCCESS);
        return ResponseEntity.ok(customerFindResponse);
    }
}
