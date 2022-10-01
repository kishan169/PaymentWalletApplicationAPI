package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.masai.exception.CustomerNotException;
import com.masai.exception.TransactionNotFoundException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.Wallet;

public interface TransactionService {
	
	
	
	public List<Transaction> viewAlltransaction(String  uniqueId)throws UserNotLogedinException, TransactionNotFoundException ;
	
	public List<Transaction> viewTranscationByDate(LocalDate from, LocalDate to , String uniqueId)  throws UserNotLogedinException,TransactionNotFoundException ;
		
	public List<Transaction> viewAllTransaction(String uniqueId,TransactionType type) throws UserNotLogedinException, TransactionNotFoundException;

}
