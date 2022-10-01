package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BillNotExisttException;
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
	public ResponseEntity<BillPayment> addNewBillPaymentDetails(@RequestBody BillPayment billPayment, @PathVariable String uniqueId) throws UserNotLogedinException, InsufficientBalanceException {
		
		BillPayment addBill =  bService.makeBillPayment(billPayment, uniqueId);
		
		return new ResponseEntity<BillPayment> (addBill, HttpStatus.CREATED);
	}
	
	@GetMapping("/billPayment/{uniqueId}/{billId}")
	public ResponseEntity<BillPayment>getBillDetailsByBillIdHandler(@PathVariable("billId")Integer billId, @PathVariable String uniqueId) throws BillNotExisttException, UserNotLogedinException{
		
		BillPayment bDetails=bService.getBillPaymentDetailseByBillId(billId);
		
		return new ResponseEntity<BillPayment>(bDetails, HttpStatus.OK);		
		
	}
}
