package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.SignUp;
import com.masai.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUp> createNewSignUpHandler(@RequestBody SignUp newSignUp) throws LoginException {
		
		SignUp newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<SignUp>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUp> updateSignUpDetailsHandler(@RequestBody SignUp signUp, @RequestParam String key) throws LoginException
	{
		SignUp newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<SignUp>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}
}
