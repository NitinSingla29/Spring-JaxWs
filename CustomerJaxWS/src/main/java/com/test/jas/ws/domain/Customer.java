package com.test.jas.ws.domain;

public class Customer {

	private String id;
	
	private String name;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
