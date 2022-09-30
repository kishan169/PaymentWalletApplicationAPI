package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.BillPayment;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.TransactionDao;

import java.util.*;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Autowired
	private TransactionDao transactionDao;


	@Override
	public BillPayment PayBill(BillPayment billpayment, String key) throws LoginException {
		
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(key);
		
		
		if(!currentUser.isPresent()) {
			throw new LoginException("You have to Login First!");
		}
		
		Optional<Customer> customer = customerDao.findById(currentUser.get().getUserId());
		
		Wallet wallet = customer.get().getWallet();
		System.out.println(wallet.getWalletId());
		billpayment.setWalletId(wallet.getWalletId());
		billpayment.setTime(LocalDateTime.now());
		
//		Transaction transaction = new Transaction();
//		transaction.setAmount(billpayment.getAmount());
//		transaction.setTransactionDate(LocalDateTime.now());
//		transaction.setTransactionType(billpayment.getTransactiontype());
//		transaction.setBillType(billpayment.getBilltype());
//		
//		Transaction tr =  transactionDao.save(transaction);
		
		return billDao.save(billpayment);
		
	}





	

	
	
}
