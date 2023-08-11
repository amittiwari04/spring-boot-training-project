package com.example.demo.exception;

public class VehicleNotFoundException extends RuntimeException{
	
	private String message;

	public VehicleNotFoundException(String message) {
		super();
		this.message = message;
	}

	public VehicleNotFoundException() {
		super();
	}
	
	
	

}
