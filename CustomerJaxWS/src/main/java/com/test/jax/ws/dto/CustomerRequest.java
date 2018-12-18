package com.test.jax.ws.dto;

public class CustomerRequest {

	private String id;

	public CustomerRequest() {
		super();
	}

	public CustomerRequest(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
