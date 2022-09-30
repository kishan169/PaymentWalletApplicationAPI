package com.masai.exception;

public class UserNotLogedinException extends RuntimeException {

	
	public UserNotLogedinException() {}

	public UserNotLogedinException(String message) {
		super(message);
	}
	
}
