package com.masai.service;

import com.masai.model.*;
import com.masai.exception.LoginException;

public interface SignUpService {
	
	public SignUp createNewSignUp(SignUp signUp) throws LoginException;;
	
	public SignUp updateSignUpDetails(SignUp signUp,String key) throws LoginException;
}
