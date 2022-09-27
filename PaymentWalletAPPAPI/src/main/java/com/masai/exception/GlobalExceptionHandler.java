package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> HandleLoginException(LoginException loginException , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> HandleExtraException(Exception loginException , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
