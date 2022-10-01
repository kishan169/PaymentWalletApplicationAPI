package com.masai.controllers;

import java.math.BigDecimal;

import java.util.List;

import javax.naming.InsufficientResourcesException;

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

import com.masai.exception.BeneficiaryDetailException;
import com.masai.exception.CustomerNotException;
import com.masai.exception.LoginException;
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
// @RequestMapping("/Wallet")
public class WalletController {

	@Autowired
	private WalletServiceImpl walletServiceImpl;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private SessionDAO sessiondao;

	@Autowired
	private CurrentUserSessionServiceImpl currentuserSesionServiceImpl;
<<<<<<< HEAD
	
=======

	// =============================

	// /public Customer createAccount(String name,String moblieNo,BigDecimal
	// amount);

	// public Double showBalance(String mobileNo) throws CustomerNotException;
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
	@GetMapping("/balance/{mobileNo}")
	public ResponseEntity<Double> showBalanceHandler(@PathVariable("mobileNo") String mobileNo)
			throws CustomerNotException, LoginException {
		Double balance = walletServiceImpl.showBalance(mobileNo);
<<<<<<< HEAD
		return balance;
	}
	
	@PutMapping("/fundtran/{sourceMobileNo}/{tragetMobileNo}/{amount}")
	public Transaction FundTransactionHandler(@PathVariable("sourceMobileNo") String sourceMobileNo,@PathVariable("tragetMobileNo") String tragerMobileNo,@PathVariable("amount") Double amount) throws CustomerNotException {
		return walletServiceImpl.fundTransfer(sourceMobileNo, tragerMobileNo, amount);
	}

	@PutMapping("/deposite/{mobileNo}/{amount}")
	public Transaction depositeAmountFromWalletToBankHandler(@PathVariable("moblieNo") String mobileNo,@PathVariable("amount") Double amount) throws CustomerNotException {
		return walletServiceImpl.depositeAmount(mobileNo, amount);
	}

=======

		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}

	// public Transaction fundTransfer(String sourceMoblieNo,String
	// targetMobileNo,BigDecimal amout);
	@PutMapping("/fundtran/{sourceMobileNo}/{tragetMobileNo}/{amount}/{uniqueId}")
	public ResponseEntity<Transaction> FundTransactionHandler(@PathVariable("sourceMobileNo") String sourceMobileNo,
			@PathVariable("tragetMobileNo") String tragerMobileNo, @PathVariable("amount") Double amount,@PathVariable("uniqueId") String uniqueId)
			throws CustomerNotException, LoginException, BeneficiaryDetailException {

		Transaction transaction = walletServiceImpl.fundTransfer(sourceMobileNo, tragerMobileNo, amount,uniqueId);

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	// public Customer depositeAmount(String mmobileNo,BigDecimal amount);
	@PutMapping("/deposite/{mobileNo}/{amount}")
	public ResponseEntity<Transaction> depositeAmountFromWalletToBankHandler(@PathVariable("moblieNo") String mobileNo,
			@PathVariable("amount") Double amount)
			throws CustomerNotException, InsufficientResourcesException, LoginException {

		Transaction transaction = walletServiceImpl.depositeAmount(mobileNo, amount);
		System.out.println("yes there is problem over here");

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	// public List<Customer> getList();
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
	@GetMapping("/getbenList/{mobileNo}")
	public ResponseEntity<List<BeneficiaryDetail>> getAllCoustomerFromWallet(@PathVariable("mobileNo") String mobileNo)
			throws CustomerNotException, LoginException, BeneficiaryDetailException {
		List<BeneficiaryDetail> beneficiaryDetails = walletServiceImpl.getList(mobileNo);

		return new ResponseEntity<List<BeneficiaryDetail>>(beneficiaryDetails, HttpStatus.OK);
	}
<<<<<<< HEAD
	
	@PostMapping("/addmoney/{mobile}/{am}")
	public Customer addMoneyFromBankToWallet(@PathVariable("mobile") String mobileNo,@PathVariable("am") Double amount) throws Exception {
	    return walletServiceImpl.addMoney(mobileNo, amount);
=======

	// lsCustomer addMoney(Wallet wallet, Double amount);
	@PostMapping("/addMoney/{mobileNo}/{amount}")
	public ResponseEntity<Customer> addMoneyHandler(String mobileNo, Double amount) throws Exception {

		Customer customer = walletServiceImpl.addMoney(mobileNo, amount);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
	}

}
