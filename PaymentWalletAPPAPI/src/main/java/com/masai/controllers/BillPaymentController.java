package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.InsufficientBalanceException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BillPayment;
import com.masai.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService bService;
	
	@PostMapping("/billPayment/{uniqueId}")
	public BillPayment addNewBillPaymentDetails(@RequestBody BillPayment billPayment, @PathVariable String uniqueId) throws UserNotLogedinException, InsufficientBalanceException {
		
		BillPayment bp =  bService.makeBillPayment(billPayment, uniqueId);
		return bp;
	}
}
