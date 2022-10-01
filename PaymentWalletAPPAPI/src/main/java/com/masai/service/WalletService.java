package com.masai.service;

import java.math.BigDecimal;

import java.util.*;

import javax.naming.InsufficientResourcesException;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.exception.CustomerNotException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface WalletService {

	
	
	public  Double showBalance(String mobileNo) throws CustomerNotException, LoginException;
	
	public Transaction fundTransfer(String sourceMoblieNo,String targetMobileNo,Double amout) throws CustomerNotException, BeneficiaryDetailException, LoginException;
	
	public Transaction depositeAmount(String mobileNo,Double amount) throws CustomerNotException, LoginException, InsufficientResourcesException;
	
	public List<BeneficiaryDetail> getList(String mobileNo) throws CustomerNotException, LoginException, BeneficiaryDetailException;
	
	
	
	public Customer addMoney(String mobileNo, Double amount) throws Exception;
	
}
