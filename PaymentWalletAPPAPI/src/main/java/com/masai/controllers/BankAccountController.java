package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@PostMapping("/bank/add")
	public BankAccount addBankAccountToWallet(@RequestBody BankAccount bankaccount) {
		System.out.println(bankaccount.toString());
		BankAccount bank =bankService.addBankDetail(bankaccount);
		return bank;
	}
}
