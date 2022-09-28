package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;

	@Override
	public Customer createNewSignUp(Customer newSignUp) throws LoginException {
		Optional<Customer> opt = signUpDAO.findByUserName(newSignUp.getUserName());
		if(opt.isPresent())
		{
			throw new LoginException("User Already Exist!");
		}
		
		return signUpDAO.save(newSignUp);
	}

	@Override
	public Customer updateSignUpDetails(Customer signUp, String key) throws LoginException {
		Customer signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LoginException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LoginException("Can't change UserId!!");
	}

	
	

}
