package com.woo.bo.exceptions;

public class UserAlreadyPresentException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private long fieldValue;
	public UserAlreadyPresentException(String resourceName, String fieldName, long l) {
		super(String.format("%s already present with %s: '%d'", resourceName,fieldName,l));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = l;
	}
	
	
}
