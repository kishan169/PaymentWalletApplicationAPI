package com.masai.service;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotException;
import com.masai.exception.LoginException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.TransactionDao;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private TransactionDao transactiodao;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private SessionDAO currentSessionDAO;
	
	@Override
	public Customer createAccount(String name, String moblieNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showBalance(String mobileNo) throws CustomerNotException {

		Optional<CurrentSessionUser> currentSessionOptional = currentSessionDAO.findByMobileNo(mobileNo);
		
		if(!currentSessionOptional.isPresent()) {
			throw new CustomerNotException("You have to login First");
		}
		
		Optional<Customer> customer =  customerDAO.findByMobileNo(mobileNo);
		
		Wallet wallet =  customer.get().getWallet();
		
		wallet.getBalance();
		Optional<Customer> currentUser=null;// = .findByMobileNo(mobileNo);
		
		if(currentUser==null) {
			throw new CustomerNotException("Customer not there");
		}
		
		//Customer customer = currentUser.get();
		
		//Wallet userwallet = customer.getWallet();
		
		//Double balance = userwallet.ge
		
		
		return null;
	}

	@Override
	public Customer fundTransfer(String sourceMoblieNo, String targetMobileNo, BigDecimal amout) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositeAmount(String mmobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer UpdateAmount(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addMoney(Wallet wallet, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
