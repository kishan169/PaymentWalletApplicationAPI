package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.BankAccount;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;

@Service
public class BanKAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Override
	public BankAccount addBankDetail(BankAccount bankAccount) {
		CurrentSessionUser currentSession =  LoginServiceImpl.getCurrentUser();
		
		
		Optional<Customer> customer =  cDao.findById(currentSession.getUserId());
		Wallet wallet = customer.get().getWallet();
		bankAccount.setWalletId(wallet.getWalletId());
		return bankDao.save(bankAccount);
	}

}
