package com.masai.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BankAccountNotExsists;
import com.masai.exception.BankAlreadyAdded;
import com.masai.exception.NotAnyBankAddedYet;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BankAccount;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;

@Service
public class BanKAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	@Autowired
	private CustomerDAO cDao;
	@Autowired
	private LogInDAO logInDAO;
//	-1608047387
	@Override
	public BankAccount addBank(BankAccount bankAccount, String uniqueId) throws UserNotLogedinException,BankAlreadyAdded {

		Customer user = cDao.findById((sessionDao.findByUuid(uniqueId).get()).getUserId()).get();
		
		if(user==null) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		
		if((bankDao.findById(bankAccount.getAccountNumber())).isPresent()) {
			throw new BankAlreadyAdded("Bank with "+bankAccount.getAccountNumber()+" this Account Nuber Already Exist");
		}
		Optional<Customer> customer =  cDao.findById(user.getUserId());
		Wallet wallet = customer.get().getWallet();
		System.out.println(wallet.getWalletId());
		bankAccount.setWalletId(2);
		return bankDao.save(bankAccount);

	}



	@Override
	public BankAccount removeBank(Integer accountNumber, String uniqueId)
			throws BankAccountNotExsists, UserNotLogedinException {
Customer user = cDao.findById((sessionDao.findByUuid(uniqueId).get()).getUserId()).get();
		
		if(user==null) {
			throw new UserNotLogedinException("Please Login first");
		}
//		if((bankDao.findById(getAccountNumber())).isPresent()) {
//			throw new BankAlreadyAdded("Bank with "+bankAccount.getAccountNumber()+" this Account Nuber Already Exist");
//		}
		return null;
		
	}

	@Override
	public BankAccount viewBankAccountI(Integer accountNumber, String uniqueId)
			throws BankAccountNotExsists, UserNotLogedinException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<BankAccount> viewAllAccount(String uniqueId) throws UserNotLogedinException, NotAnyBankAddedYet {
		// TODO Auto-generated method stub
		return null;
	}

}
