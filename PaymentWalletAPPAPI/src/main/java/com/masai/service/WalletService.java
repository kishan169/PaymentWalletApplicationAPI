package com.masai.service;

import java.math.BigDecimal;

import java.util.*;

import com.masai.exception.CustomerNotException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface WalletService {

	public Customer createAccount(String name,String moblieNo,BigDecimal amount);
	
	public  Double showBalance(String mobileNo) throws CustomerNotException;
	
	public Transaction fundTransfer(String sourceMoblieNo,String targetMobileNo,Double amout) throws CustomerNotException;
	
	public Transaction depositeAmount(String mobileNo,Double amount) throws CustomerNotException;
	
	public List<BeneficiaryDetail> getList(String mobileNo) throws CustomerNotException;
	
	public Customer UpdateAmount(Customer customer) throws CustomerNotException;
	
	public Customer addMoney(Wallet wallet, Double amount);
	
}
