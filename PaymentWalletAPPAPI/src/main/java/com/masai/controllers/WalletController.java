package com.masai.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.Wallet;
import com.masai.repository.SessionDAO;
import com.masai.service.CurrentUserSessionServiceImpl;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.WalletServiceImpl;

@RestController
@RequestMapping("/Wallet")
public class WalletController {
	
	@Autowired
	private WalletServiceImpl walletServiceImpl;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	private SessionDAO sessiondao;
	
	@Autowired
	private CurrentUserSessionServiceImpl currentuserSesionServiceImpl;
	
	//=============================
	
	
//		/public Customer createAccount(String name,String moblieNo,BigDecimal amount);
	@PostMapping()
	public ResponseEntity<Customer> createAccountHandler(String name,String moblieNo, BigDecimal amount){
		
		Customer customer = walletServiceImpl.createAccount(name, moblieNo, amount);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	
//	public  Double showBalance(String mobileNo) throws CustomerNotException;
	
//	public ResponseEntity<T>
	
	
	
//	public Customer fundTransfer(String sourceMoblieNo,String targetMobileNo,BigDecimal amout);
	
	
	
	
//	public Customer depositeAmount(String mmobileNo,BigDecimal amount);
	
	
	
	
	
//	public List<Customer> getList();
	
	
	
	
	
//	public Customer updateAcount(Customer customer);
	
	
	
	
	
	
//	public Customer addMoney(Wallet wallet, Double amount);
	
	
	
	

}
