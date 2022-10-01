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
	
	
	
	//==========================
	





	@Override
	public List<Transaction> viewAlltransaction(String  uniqueId) throws UserNotLogedinException, TransactionNotFoundException {
		
		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User is not Login");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		
		
		Wallet wallet = customer.get().getWallet();
		
		List<Transaction> transactions  = wallet.getTransaction();
		
		if(transactions.size()>0) {
			return transactions;
		}else {
			throw new TransactionNotFoundException("trnasation not found");
		}
		
	}

<<<<<<< HEAD
	
=======
	@Override
	public List<Transaction> viewTranscationByDate(String from, String  to,String uniqueId) throws UserNotLogedinException,TransactionNotFoundException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("yes im in");

		LocalDate start = LocalDate.parse(from, formatter);
		LocalDate end = LocalDate.parse(to, formatter);
		
		System.out.println(start);
		System.out.println("there");
		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User not logedin");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		
		
		Wallet wallet = customer.get().getWallet();
		
		List<Transaction> transaction = wallet.getTransaction();
		
		List<Transaction> transactionbydate = new ArrayList<>();
		
		for(Transaction tr: transaction) {
			
			LocalDateTime localDateTime = tr.getTransactionDate();
			
			String date = localDateTime.getDayOfMonth() + "-0" + localDateTime.getMonthValue() + "-"+ localDateTime.getYear();
			
			LocalDate temp = LocalDate.parse(date, formatter);
			
			if ((temp.isAfter(start) && temp.isBefore(end)) || temp.equals(start) || temp.equals(end)) {
				
				transactionbydate.add(tr);
			}
			
			
		}
		
		return transactionbydate;
		
	}
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2

	@Override
	public List<Transaction> viewAllTransactionbyTransactionType(String uniqueId,TransactionType type) throws UserNotLogedinException,TransactionNotFoundException  {

		Optional<CurrentSessionUser> optional = sessionDao.findByUuid(uniqueId);
		
		if(!optional.isPresent()) {
			throw new UserNotLogedinException("User not logedin");
		}
		
		Optional<Customer> customer=  customerDAO.findById(optional.get().getUserId());
		
		
		Wallet wallet = customer.get().getWallet();
		
		List<Transaction> transaction = wallet.getTransaction();
		
		List<Transaction> transactionslist = transactiondao.getTransactionByTransactionType(type);
		
		if(transactionslist.size()>0) {
			return transactionslist;
		}else {
			throw new TransactionNotFoundException("trnasation not found");
		}
	}

<<<<<<< HEAD
    @Override
    public Transaction addTranscation(Transaction tran) {
        // TODO Auto-generated method stub
        return null;
    }



	@Override
	public Set<Transaction> viewTranscationByDate(String from, String to) {
		// TODO Auto-generated method stub
		return null;
	}

=======
   
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
}
