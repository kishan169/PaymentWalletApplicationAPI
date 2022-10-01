package com.masai.service;

import java.time.LocalDate;
import java.util.*;

import com.masai.exception.CustomerNotException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BillType;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface TransactionService {
	
	
	public Set<Transaction> viewAlltransaction(String uniqueId) throws UserNotLogedinException;
	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to);
	public Set<Transaction> viewAllTransactionByType(BillType billtype);

}
