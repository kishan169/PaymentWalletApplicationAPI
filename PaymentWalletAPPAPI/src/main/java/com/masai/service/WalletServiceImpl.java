package com.masai.service;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.Wallet;
import com.masai.repository.TransactionDao;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private TransactionDao transactiodao;
	
	@Autowired
	private CustomerService cutomerservice;
	
	

	@Override
	public Customer createAccount(String name, String moblieNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double showBalance(String mobileNo) throws CustomerNotException {
		// TODO Auto-generated method stub
		
		Optional<Customer> currentUser=null;// = .findByMobileNo(mobileNo);
		
		if(currentUser==null) {
			throw new CustomerNotException("Customer not there");
		}
		
		Customer customer = currentUser.get();
		
		Wallet userwallet = customer.getWallet();
		
		Double bal = userwallet.getBalance();
		
		
		return bal;
	}

	@Override
	public Customer fundTransfer(String sourceMoblieNo, String targetMobileNo, BigDecimal amout) {
		
		//sourceMobileNo = Currentuser moblieNo; find the current user ;
		
		
		//after finding the currentuser get the currentUser customer list ;
		//check the targetmobileNo is present in the user list ;
		//if there transfer the amount ;//at the same time deduct the amout fro mthe user acc also;
		//or throw the error;
		
		
		
		
		
		return null;
	}

	@Override
	public Customer depositeAmount(String mmobileNo, BigDecimal amount) {
		
		//find the customer by the mobileNo;
		//if found add the amount to the account;
		//else throw error;
		return null;
	}

	@Override
	public List<Customer> getList() {
		
		//get the currentuser;
	
		//gett the list of all the customer of the curretUser;
		
		return null;
	}

	

	@Override
	public Customer addMoney(Wallet wallet, Double amount) {
		// find the wallet ;
		//add the amount;
		return null;
	}

	@Override
	public Customer updateAcount(Customer customer) {
		// find the customer account ;
		//and update it;
		return null;
	}

}
