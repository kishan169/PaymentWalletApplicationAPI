package com.masai.controllers;
import com.masai.exception.CustomerNotException;
import com.masai.exception.TransactionNotFoundException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.Wallet;
import com.masai.service.TranscationServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TranscationServiceImpl transactionserviceimpl;
	
	
	

	
	
//	public Set<Transaction> viewAlltransaction(Wallet wallet) throws CustomerNotException;
	@GetMapping("/transation_histroy")
	public ResponseEntity<List<Transaction>> viewAllTransactionHandler( @RequestBody String uniqueId) throws CustomerNotException, UserNotLogedinException, TransactionNotFoundException{
		
		List<Transaction> allTransaction = transactionserviceimpl.viewAlltransaction(uniqueId);
		
		return new ResponseEntity<List<Transaction>>(allTransaction,HttpStatus.OK);
	}
	
	
	
	
//	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to);
<<<<<<< HEAD
	@GetMapping("/historyByDate/{st}/{to}")
	public ResponseEntity<Set<Transaction>> viewTransactionByDatehandler(@PathVariable("st") String from,@PathVariable("to") String to){
=======
	@GetMapping("/historyByDate")
	public ResponseEntity<List<Transaction>> viewTransactionByDatehandler(LocalDate from,LocalDate to,String uniqueId) throws CustomerNotException, UserNotLogedinException, TransactionNotFoundException{
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
		
		List<Transaction> historyByDate= transactionserviceimpl.viewTranscationByDate(from,to,uniqueId);
		
		return new ResponseEntity<List<Transaction>>(historyByDate,HttpStatus.OK);
	}
	
	
	
	
	
//	public Set<Transaction> viewAllTransactionaa(String type);
	@GetMapping("/historybytype/{transactiontype}")
	public ResponseEntity<List<Transaction>> viewAllTransactionByTypeHandler(@PathParam("transactiontype") TransactionType type,@PathVariable String uniqueId) throws CustomerNotException, UserNotLogedinException, TransactionNotFoundException{
		
		List<Transaction> TransactionType = transactionserviceimpl.viewAllTransaction(uniqueId,type);
		
		return new ResponseEntity<List<Transaction>>(TransactionType,HttpStatus.OK);
	}
	
	
}
