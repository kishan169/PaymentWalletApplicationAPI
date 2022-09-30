package com.masai.service;

import java.time.LocalDate;
import java.util.*;

import com.masai.exception.CustomerNotException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface TransactionService {
	
	
	public Transaction addTranscation(Transaction tran);
	public Set<Transaction> viewAlltransaction(Wallet wallet) throws CustomerNotException;
	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to);
	public Set<Transaction> viewAllTransaction(String type);

}
