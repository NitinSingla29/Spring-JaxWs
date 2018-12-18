package com.test.exception;

public class MissingCustomerIdException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingCustomerIdException(String msg) {
    	super(msg);
    }
}
