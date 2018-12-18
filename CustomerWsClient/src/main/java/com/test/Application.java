package com.test;

import javax.xml.ws.BindingProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.jax.ws.service.CustomerService;
import com.test.jax.ws.service.CustomerServiceService;

@SpringBootApplication
@Configuration
public class Application {

	private final static String END_POINT_URL = "http://localhost:8082/customer";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CustomerService customerServiceService () {
		CustomerService customerServicePort = new CustomerServiceService().getCustomerServicePort();
		((BindingProvider) customerServicePort).getRequestContext().put(
	            BindingProvider.ENDPOINT_ADDRESS_PROPERTY, END_POINT_URL);
		return customerServicePort;
	}

}

