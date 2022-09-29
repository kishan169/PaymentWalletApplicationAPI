package com.masai.service;

import java.time.LocalDate;

import com.masai.model.Transaction;
import com.masai.model.Wallet;

import java.util.*;

public interface TransactionService {
	
	public Transaction addTranscation(Transaction tran);
	
	public Transaction viewAlltransaction(Wallet wallet);
	
	public List<Transaction> viewTranscationByDate(LocalDate from, LocalDate to);
	
	public List<Transaction> viewAllTransaction(String type);

}
