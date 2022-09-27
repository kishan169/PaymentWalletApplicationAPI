package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.LogIn;
import com.masai.model.SignUp;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.SignUpDAO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private SessionDAO SessionDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Autowired
	private LogInDAO loginDAO;

	@Override
	public String logInAccount(LogIn loginData) throws LoginException {
		Optional<SignUp> options = signUpDAO.findById(loginData.getUserId());
		
		if(!options.isPresent()) {
			throw new LoginException("Invalid Login UserId");
		}
		
		SignUp newSignUp = options.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<CurrentSessionUser> currentSessionUser = SessionDAO.findByUserId(newSignUpId);
		
		if(currentSessionUser.isPresent()) {
			throw new LoginException("User already login with this userId");
		}
		
		if((newSignUp.getUserId()==loginData.getUserId())  && newSignUp.getPassword().equals(loginData.getPassword())) {
			String key = RandomString.getRandomString();
			CurrentSessionUser currentSessionUser2 = new CurrentSessionUser(newSignUp.getUserId(), key, LocalDateTime.now());
			loginDAO.save(loginData);
			return currentSessionUser2.toString();
		}else {
			throw new LoginException("Invalid username and Password");
		}
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		Optional<CurrentSessionUser> currentSessionuserOptional = SessionDAO.findByUuid(key);
		
		if(!currentSessionuserOptional.isPresent()) {
			throw new LoginException("User has not looged in with this Userid");
		}
		
		CurrentSessionUser currentSessionUser =getCurrentLoginUserSession.getCurrentUserSession(key);
		
		SessionDAO.delete(currentSessionUser);
		
		Optional<LogIn> logindata = loginDAO.findById(currentSessionuserOptional.get().getUserId());
		
		System.out.println(logindata);
		loginDAO.delete(logindata.get());
		
		
		return "Logged Out....";
	}
	

}
