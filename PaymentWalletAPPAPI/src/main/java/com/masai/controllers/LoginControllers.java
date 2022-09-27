package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.LogIn;
import com.masai.model.SignUp;
import com.masai.service.LoginService;
import com.masai.service.SignUpService;


@RestController
public class LoginControllers {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LogIn loginData) throws LoginException {
		return loginService.logInAccount(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws LoginException
	{
		return loginService.logOutFromAccount(key);
	}
	
	
	
}
