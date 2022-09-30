package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.service.BankAccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankService;

	
	@PostMapping("/bank/{id}")
	public  ResponseEntity<BankAccount> addBankAccountToWallet(@RequestBody BankAccount bankaccount,@PathVariable("id") String uniqueId) {
		//System.out.println(bankaccount.toString(),uniqueId);
		//BankAccount bank =bankService.addBank(bankaccount,uniqueId);
		//return bank;
		BankAccount aaccountAdded = bankService.addBank(bankaccount,"-1608047387");
		return new ResponseEntity<>(bankaccount,HttpStatus.ACCEPTED);
	}
	
}
