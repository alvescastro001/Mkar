package com.mkt.car.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1052790890873076611L;
	
	public NotFoundException(String message) {
		super(message);
	}

}
