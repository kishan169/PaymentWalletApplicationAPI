package com.masai.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.SessionDAO;
import com.masai.service.CurrentUserSessionServiceImpl;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.WalletServiceImpl;

@RestController
//@RequestMapping("/Wallet")
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
	@GetMapping("/balance/{mobileNo}")
	public Double showBalanceHandler(@PathVariable("mobileNo") String mobileNo) throws CustomerNotException {
		Double balance = walletServiceImpl.showBalance(mobileNo);
		
		return balance;
	}
	
	
	
//	public Transaction fundTransfer(String sourceMoblieNo,String targetMobileNo,BigDecimal amout);
	@PutMapping("/fundtran/{sourceMobileNo}/{tragetMobileNo}/{amount}")
	public Transaction FundTransactionHandler(@PathVariable("sourceMobileNo") String sourceMobileNo,@PathVariable("tragetMobileNo") String tragerMobileNo,@PathVariable("amount") Double amount) throws CustomerNotException {
		
		return walletServiceImpl.fundTransfer(sourceMobileNo, tragerMobileNo, amount);
		
	}
	
	
//	public Customer depositeAmount(String mmobileNo,BigDecimal amount);
	
	public Transaction depositeAmountFromWalletToBankHandler(@PathVariable("moblieNo") String mobileNo,@PathVariable("amount") Double amount) throws CustomerNotException {
		
		
		return walletServiceImpl.depositeAmount(mobileNo, amount);
	}
	
	
	
	
//	public List<Customer> getList();
	@GetMapping("/getbenList/{mobileNo}")
	public List<BeneficiaryDetail> getAllCoustomerFromWallet(@PathVariable("mobileNo") String mobileNo) throws CustomerNotException{
		return walletServiceImpl.getList(mobileNo);
	}
	
	
	
//	public Customer updateAcount(Customer customer);
	@PatchMapping("/update")
	public Customer updateAccountHandeler(@RequestBody Customer coustomer) throws CustomerNotException {
		
		return walletServiceImpl.UpdateAmount(coustomer);
	}
	
	
	
	
//	public Customer addMoney(Wallet wallet, Double amount);
	
	
	
	

}
