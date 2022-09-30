package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class SignUpController {
	
	@Autowired
	private CustomerService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<Customer> createNewSignUpHandler(@RequestBody Customer newSignUp) throws LoginException {
		
		Customer newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<Customer>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<Customer> updateSignUpDetailsHandler(@RequestBody Customer signUp, @RequestParam String key) throws LoginException
	{
		Customer newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<Customer>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}
}
