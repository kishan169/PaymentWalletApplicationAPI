package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BillPaymentException;

import com.masai.model.BillPayment;

import com.masai.service.BillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billpaymentservice;
	
	@PostMapping("/billpayments")
	public ResponseEntity<BillPayment> addBillPaymentHandler(@RequestBody BillPayment bp) throws BillPaymentException{
		
		BillPayment addBP=billpaymentservice.addBillPayment(bp);
		
		return new ResponseEntity<BillPayment>(addBP,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/billpayments/{billId}")
	public ResponseEntity<BillPayment>getBillPaymentDetailsByBillIDHandler(@PathVariable("billId")Integer billId) throws BillPaymentException{
		
		BillPayment bp=billpaymentservice.viewBillPayment(billId);
		
		return new ResponseEntity<BillPayment>(bp, HttpStatus.OK);		
		
	}
	
	
	

}
