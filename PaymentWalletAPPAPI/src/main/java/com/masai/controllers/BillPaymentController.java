package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.InsufficientBalanceException;
import com.masai.model.BillPayment;
import com.masai.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService bService;
	
	@PostMapping("/billPayment/{id}")
	public BillPayment addNewBillPaymentDetails(@RequestBody BillPayment billPayment,@PathVariable("id") String uniqueId) throws InsufficientBalanceException {
		BillPayment bp =  bService.makeBillPayment(billPayment, uniqueId);
		return bp;
	}
}
