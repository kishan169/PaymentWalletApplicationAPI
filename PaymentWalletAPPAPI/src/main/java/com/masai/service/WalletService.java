package com.masai.service;

import java.math.BigDecimal;

import java.util.*;

import com.masai.exception.CustomerNotException;
import com.masai.model.Customer;
import com.masai.model.Wallet;

public interface WalletService {

	public Customer createAccount(String name,String moblieNo,BigDecimal amount);
	
	public  Customer showBalance(String mobileNo) throws CustomerNotException;
	
	public Customer fundTransfer(String sourceMoblieNo,String targetMobileNo,BigDecimal amout);
	
	public Customer depositeAmount(String mmobileNo,BigDecimal amount);
	
	public List<Customer> getList();
	
	public Customer UpdateAmount(Customer customer);
	
	public Customer addMoney(Wallet wallet, Double amount);
	
}
