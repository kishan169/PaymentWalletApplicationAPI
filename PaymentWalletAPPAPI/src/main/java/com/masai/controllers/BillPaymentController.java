package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BillPayment;
import com.masai.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService bService;
	
	@PostMapping("/billPayment")
	public BillPayment addNewBillPaymentDetails(@RequestBody BillPayment billPayment) {
		BillPayment bp =  bService.addbillPayment(billPayment);
		return bp;
	}
}
