package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.BillPayment;
import com.masai.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService bService;
	
	@PostMapping("/billPayment")
	public BillPayment addNewBillPaymentDetails(@RequestBody BillPayment billPayment) throws LoginException {
		BillPayment bp =  bService.PayBill(billPayment,"1587752550");
		return bp;
	}
}
