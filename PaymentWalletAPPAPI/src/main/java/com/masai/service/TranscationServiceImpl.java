package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.WalletDao;

public class TranscationServiceImpl implements TransactionService{
	
	
	@Autowired
	private WalletDao walletdao;
	

	@Override
	public Transaction addTranscation(Transaction tran) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction viewAlltransaction(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> viewTranscationByDate(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> viewAllTransaction(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
