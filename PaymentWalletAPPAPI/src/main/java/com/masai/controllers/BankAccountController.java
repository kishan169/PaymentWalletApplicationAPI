package com.masai.controllers;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.service.BankAccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@CrossOrigin(origins = "*")
@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankService;

	
	@PostMapping("/bank/{id}")
	public  ResponseEntity<BankAccount> addBankAccountToWallet(@RequestBody BankAccount bankaccount,@PathVariable("id") String uniqueId) {
		BankAccount aaccountAdded = bankService.addBank(bankaccount,uniqueId);
		return new ResponseEntity<>(bankaccount,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/bank/{acc}/{id}")
	public  ResponseEntity<BankAccount> deleteBankAccountfromWallet( @PathVariable("acc") Integer accountNumber,@PathVariable("id") String uniqueId) {
		BankAccount accountDeleted = bankService.removeBank(accountNumber, uniqueId);
		return new ResponseEntity<BankAccount>(accountDeleted,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bank/{acc}/{id}")
	public  ResponseEntity<BankAccount> viewBankAccountDetails( @PathVariable("acc") Integer accountNumber,@PathVariable("id") String uniqueId) {
		BankAccount accountDetails = bankService.viewBankAccountI(accountNumber, uniqueId);
		return new ResponseEntity<BankAccount>(accountDetails,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bank/{id}")
	public  ResponseEntity<Set<BankAccount>> viewAllBankAccountDetails(@PathVariable("id") String uniqueId) {
		Set<BankAccount> accountDetails = bankService.viewAllAccount(uniqueId);
		return new ResponseEntity<Set<BankAccount>>(accountDetails,HttpStatus.ACCEPTED);
	}
	
	
	
}
