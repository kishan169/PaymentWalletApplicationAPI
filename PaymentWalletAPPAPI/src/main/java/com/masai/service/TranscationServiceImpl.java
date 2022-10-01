package com.masai.service;

import java.time.LocalDate;

import com.masai.exception.CustomerNotException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.CustomerDAO;
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
	
	@Autowired
	private CustomerDAO cDao;


	@Override
	public Set<Transaction> viewAlltransaction(String uniqueId) throws UserNotLogedinException {
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
		
		if(!currentUser.isPresent()) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		Optional<Customer> customer =  cDao.findById(currentUser.get().getUserId());
		Wallet wallet = customer.get().getWallet();
		
		Set<Transaction> transactions = transactiondao.findByWalletId(wallet.getWalletId());
		return transactions;
		
	}


	@Override
	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<Transaction> viewAllTransactionByType(BillType billtype) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
