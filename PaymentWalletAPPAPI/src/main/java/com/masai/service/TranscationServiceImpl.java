package com.masai.service;

import java.time.LocalDate;

import com.masai.exception.CustomerNotException;
import com.masai.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.SessionDAO;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class TranscationServiceImpl implements TransactionService{
	
	
	@Autowired
	private WalletDao walletdao;
	
	@Autowired
	private TransactionDao transactiondao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	//==========================
	

	@Override
	public Transaction addTranscation(Transaction tran) {
		
		Wallet currentUser = walletdao.getById(tran.getWalletId());
		
		currentUser.getTransaction().add(tran);
		
		
		
		return null;
	}

	@Override
	public Set<Transaction> viewAlltransaction(Wallet wallet) throws CustomerNotException {
		
		Optional<Wallet> walletopt = walletdao.findById(wallet.getWalletId());
		
		if(walletopt.isPresent()) {
			Wallet pwallet =  walletopt.get();
			return pwallet.getTransaction();
			
		}else {
			throw new CustomerNotException("Wallet not registerd");
		}
		
		// tryong to push the file  in the git;
		
	}

	@Override
	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to) {
		
		return null;
		
	}

	@Override
	public Set<Transaction> viewAllTransaction(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
