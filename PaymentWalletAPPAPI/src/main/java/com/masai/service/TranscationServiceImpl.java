package com.masai.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.masai.exception.CustomerNotException;
import com.masai.exception.TransactionNotFoundException;
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
	private CustomerDAO customerDAO;
	
	@Autowired
	private TransactionDao transactiondao;
	
	@Autowired
	private SessionDAO sessionDao;

	@Override
	public List<Transaction> viewAlltransaction(String  uniqueId) throws UserNotLogedinException, TransactionNotFoundException {
		
		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User is not Logged in");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		
		
		Wallet wallet = customer.get().getWallet();
		
		List<Transaction> transactions  = wallet.getTransaction();
		
		if(transactions.size()>0) {
			return transactions;
		}else {
			throw new TransactionNotFoundException("Not found any transaction with wallet");
		}
		
	}


	@Override
	public List<Transaction> viewTranscationByDate(String from, String  to,String uniqueId) throws UserNotLogedinException,TransactionNotFoundException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate start = LocalDate.parse(from, formatter);
		LocalDate end = LocalDate.parse(to, formatter);
		
		System.out.println(from);
		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User not logged in");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		
		Wallet wallet = customer.get().getWallet();
		System.out.println(wallet.getWalletId());
		List<Transaction> transaction = transactiondao.findByWalletId(wallet.getWalletId());
		
		List<Transaction> transactionbydate = transactiondao.findByTransactionDate(start);
		
		for(Transaction tr: transaction) {
			LocalDateTime localDateTime = tr.getTransactionDate();
			String date = localDateTime.getDayOfMonth() + "-" + localDateTime.getMonthValue() + "-"+ localDateTime.getYear();
			
			LocalDate temp = LocalDate.parse(date, formatter);
			
			if ((temp.isAfter(start) && temp.isBefore(end)) || temp.equals(start) || temp.equals(end)) {
				
				transactionbydate.add(tr);
			}
		}
		
		return transactionbydate;
		
	}


	@Override
	public List<Transaction> viewAllTransactionbyTransactionType(String uniqueId,TransactionType type) throws UserNotLogedinException,TransactionNotFoundException  {

		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User not logged In");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		Wallet wallet = customer.get().getWallet();
		List<Transaction> transaction = wallet.getTransaction();
		List<Transaction> transactionslist = transactiondao.getTransactionByTransactionType(type);
		
		List<Transaction> transactionLists= new ArrayList<>();
		for(Transaction tr: transactionslist) {
			if(tr.getWalletId()==wallet.getWalletId()) {
				transactionLists.add(tr);
			}
		}
		
		if(transactionLists.size()>0) {
			return transactionLists;
		}else {
			throw new TransactionNotFoundException("Transaction not found");
		}
	}



}
