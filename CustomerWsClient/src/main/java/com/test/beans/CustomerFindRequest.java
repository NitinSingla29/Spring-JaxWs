package com.test.beans;

public class CustomerFindRequest {

	private String id;

	public CustomerFindRequest() {
		super();
	}

	public CustomerFindRequest(String id) {
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
