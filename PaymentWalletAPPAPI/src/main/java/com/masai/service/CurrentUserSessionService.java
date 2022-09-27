package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.SignUp;

public interface CurrentUserSessionService {
	public CurrentSessionUser getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public SignUp getSignUpDetails(String key) throws LoginException;;
}
