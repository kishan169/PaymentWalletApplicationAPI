package com.masai.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BankAccountNotExsists;
import com.masai.exception.BankAlreadyAdded;
import com.masai.exception.NotAnyBankAddedYet;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BankAccount;
import com.masai.service.BankAccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankService;

	
	@PostMapping("/bank/{id}")
	public  ResponseEntity<BankAccount> addBankAccountToWallet(@RequestBody BankAccount bankaccount,@PathVariable("id") String uniqueId) throws BankAlreadyAdded, UserNotLogedinException {
		BankAccount aaccountAdded = bankService.addBank(bankaccount,uniqueId);
		return new ResponseEntity<>(bankaccount,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/bank/{acc}/{id}")
	public  ResponseEntity<BankAccount> deleteBankAccountfromWallet( @PathVariable("acc") Integer accountNumber,@PathVariable("id") String uniqueId) throws BankAccountNotExsists, UserNotLogedinException {
		BankAccount accountDeleted = bankService.removeBank(accountNumber, uniqueId);
		return new ResponseEntity<BankAccount>(accountDeleted,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bank/{acc}/{id}")
	public  ResponseEntity<BankAccount> viewBankAccountDetails( @PathVariable("acc") Integer accountNumber,@PathVariable("id") String uniqueId) throws BankAccountNotExsists, UserNotLogedinException {
		BankAccount accountDetails = bankService.viewBankAccountI(accountNumber, uniqueId);
		return new ResponseEntity<BankAccount>(accountDetails,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bank/{id}")
<<<<<<< HEAD
	public  ResponseEntity<BankAccount> viewAllBankAccountDetails(@PathVariable("id") String uniqueId) {
=======
	public  ResponseEntity<BankAccount> viewAllBankAccountDetails(@PathVariable("id") String uniqueId) throws NotAnyBankAddedYet, UserNotLogedinException {
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
		BankAccount accountDetails = bankService.viewAllAccount(uniqueId);
		return new ResponseEntity<BankAccount>(accountDetails,HttpStatus.ACCEPTED);
	}
	
	
	
}
