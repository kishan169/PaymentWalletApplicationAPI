package com.masai.service;

import java.math.BigDecimal;

import java.util.*;

import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.exception.CustomerNotException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface WalletService {

	
	
	public  Double showBalance(String mobileNo) throws CustomerNotException;
	
	public Transaction fundTransfer(String sourceMoblieNo,String targetMobileNo,Double amout) throws CustomerNotException, BeneficiaryDetailException;
	
	public Transaction depositeAmount(String mobileNo,Double amount) throws CustomerNotException;
	
	public List<BeneficiaryDetail> getList(String mobileNo) throws CustomerNotException,BeneficiaryDetailException;
	
	public Customer addMoney(String mobileNo, Double amount) throws Exception;
	
}
