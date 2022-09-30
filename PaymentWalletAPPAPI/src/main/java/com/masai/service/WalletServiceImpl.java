package com.masai.service;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.masai.exception.CustomerNotException;
import com.masai.exception.LoginException;
import com.masai.model.BankAccount;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.BeneficiaryDetailDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private TransactionDao transactiodao;
	
	@Autowired
	private TranscationServiceImpl transactionserviceImpl;
	
	@Autowired
	private BankAccountDao bankaccountdao;
	
	@Autowired
	private BeneficiaryDetailDao beneficiaryDetailDao;
	
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private SessionDAO currentSessionDAO;
	
	@Autowired
	private LogInDAO logindao;
	
	
	
	@Override
	public Double showBalance(String mobileNo) throws CustomerNotException {
		
		Optional<CurrentSessionUser> currentSessionOptional = currentSessionDAO.findByMobileNo(mobileNo);
		
		
		if(!currentSessionOptional.isPresent()) {
			throw new CustomerNotException("You have to login First");
		}

		Optional<Customer> customer =  customerDAO.findByMobileNo(mobileNo);
		
//		to find the customer System.out.println(currentSessionOptional.get().getUserId());
		
		Wallet wallet =  customer.get().getWallet();
		
		Double balance = wallet.getBalance();
		
		return balance;
	}




	@Override
	public Transaction fundTransfer(String sourceMoblieNo, String targetMobileNo, Double amout) throws CustomerNotException {
		
		
		Optional<CurrentSessionUser> currentUser = currentSessionDAO.findByMobileNo(sourceMoblieNo);
		
		if(!currentUser.isPresent()) {
			throw new CustomerNotException("Customer not login");
		}
		
		Optional<Customer> customerUser = customerDAO.findByMobileNo(sourceMoblieNo);
		
		Customer customer = customerUser.get();
		
		Wallet wallet = customer.getWallet();
		
		
		Boolean f=true;
		List<BeneficiaryDetail> beneficiarydetails = wallet.getBeneficiaryDetails();
		for(BeneficiaryDetail bd:beneficiarydetails) {
			if (bd.getBeneficiaryMobileNo().equals(targetMobileNo)) {
				f = false;
				break;
			}
		}
		
		Optional<Customer> tragetopt = customerDAO.findByMobileNo(targetMobileNo);
		
		Customer tragetCustomer = tragetopt.get();
		
		if(f) {
			throw new CustomerNotException("beneficiary is not add to wallet list");
		}
		
		if(wallet.getBalance()<amout || wallet.getBalance()==null) {
			throw new CustomerNotException("Insifficent balance");
		}
		
		wallet.setBalance(wallet.getBalance()-amout);
		if(tragetCustomer.getWallet().getBalance()==null ) {
			tragetCustomer.getWallet().setBalance(amout);
		}else {
			tragetCustomer.getWallet().setBalance(tragetCustomer.getWallet().getBalance()+amout);
		}
		
		
		
		//add to transaction
		
		Transaction transaction = new Transaction();
        transaction.setTransactionType("WalletToWallet");
        transaction.setTransactionDate(LocalDate.now());
        transaction.setAmount(amout);
        transaction.setDescription("Fund Transfer from Wallet to Wallet");
        
        wallet.getTransaction().add(transaction);
        
        transactiodao.save(transaction);
		
		
		return transaction;
	}

	@Override
	public Transaction depositeAmount(String mobileNo, Double amount) throws CustomerNotException {
//		dposite to bank
		//find the customer by the mobileNo;
		
		Optional<CurrentSessionUser> currentUser = currentSessionDAO.findByMobileNo(mobileNo);
		
		if(!currentUser.isPresent()) {
			throw new CustomerNotException("Customer not login");
		}
		
		Optional<Customer> customerUser = customerDAO.findByMobileNo(mobileNo);
		
		Customer customer = customerUser.get();
		
		
//		got the  wallet
		Wallet wallet = customer.getWallet();
//		got the bankac
//		BankAccount bankacc = bankaccountdao.findByWalletId(wallet.getWalletId()); 
//		
//		
//
//		
//		if(bankacc==null) {
//			throw new CustomerNotException("Bank not add to the wallet yet");
//		}
//		
//		if(wallet.getBalance()==null) {
//			throw new CustomerNotException("Insifficinet balance");
//		}
//		if(wallet.getBalance()<amount) {
//			throw new CustomerNotException("Insufficient balance");
//		}
//		
//		customer.getWallet().setBalance(wallet.getBalance()-amount);
//		
//		bankacc.setBankBalance(bankacc.getBankBalance()+amount);
//		
//		bankaccountdao.save(bankacc);
//		walletDao.save(wallet);
		
		//if found add the amount to the account;
		//else throw error;
		
		Transaction transaction = new Transaction();
        transaction.setTransactionType("WalletToWallet");
        transaction.setTransactionDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setDescription("Fund Transfer from Wallet to Wallet");
        
        wallet.getTransaction().add(transaction);
        
        transactiodao.save(transaction);
        
        
        return transaction;
	}

	@Override
	public List<BeneficiaryDetail> getList(String mobileNo) throws CustomerNotException {
		
			Optional<CurrentSessionUser> currentuser = currentSessionDAO.findByMobileNo(mobileNo);
			
			if(!currentuser.isPresent()) {
				throw new CustomerNotException("not found");
			}
			
			Optional<Customer> custOptional = customerDAO.findByMobileNo(mobileNo);
			Customer curruser = custOptional.get();
			Wallet wallet = curruser.getWallet();
		
			return wallet.getBeneficiaryDetails();
		
		
		
	}

	

	

	

	@Override
	@PutMapping("/addMoney")
	public Customer addMoney(String mobileNo, Double amount) throws Exception {
//	    add 
		// TODO Auto-generated method stub
		
		Optional<CurrentSessionUser> currOptional = currentSessionDAO.findByMobileNo(mobileNo);
		
		if(!currOptional.isPresent()) {
		    throw new CustomerNotException("not found");
		}
		
		Optional<Customer> customer = customerDAO.findByMobileNo(mobileNo);
		
		Customer  currcustomer = customer.get();
		
		Wallet wallet = currcustomer.getWallet();
		
//		BankAccount bankacc = bankaccountdao.findByWalletId(wallet.getWalletId());
//		
//		if(bankacc==null) {
//		    throw new CustomerNotException("bank not linked");
//		}
//		
//		if(bankacc.getBankBalance()==0 || bankacc.getBankBalance()<amount) {
//		    throw new CustomerNotException("insufficient balance in bank");
//		}
//		
//		bankacc.setBankBalance(bankacc.getBankBalance()-amount);
//		
//		wallet.setBalance(wallet.getBalance()+amount);
//		
//		bankaccountdao.save(bankacc);
//		walletDao.save(wallet);
//		customerDAO.save(currcustomer);
//		
		
		
		
		
		Transaction transaction = new Transaction();

        transaction.setTransactionType(TransactionType.WALLET_TO_WALLET);
        transaction.setTransactionDate(LocalDateTime.now());

        transaction.setAmount(amount);
        transaction.setDescription("Fund Transfer from Wallet to Wallet");
        
        wallet.getTransaction().add(transaction);
        
        transactiodao.save(transaction);
        
        
        return currcustomer;
		
		
	}

	
	

}
