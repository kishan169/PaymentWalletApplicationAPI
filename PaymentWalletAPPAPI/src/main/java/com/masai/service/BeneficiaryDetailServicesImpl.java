package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BeneficiaryDetailDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.WalletDao;
@Service
public class BeneficiaryDetailServicesImpl implements BeneficiaryDetailServices{
	@Autowired
	private BeneficiaryDetailDao bDao;
	@Autowired
	private SessionDAO sDao;
	@Autowired
	private WalletDao wDao;
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	public BeneficiaryDetail addBeneficiary(BeneficiaryDetail beneficiaryDetail,String mobile) throws BeneficiaryDetailException {
		Optional<CurrentSessionUser> curentSessionOpt= sDao.findByMobileNo(mobile);
		if(curentSessionOpt.isPresent()){
			CurrentSessionUser user=curentSessionOpt.get();
			int userId=user.getUserId();
			
			Optional<Customer> customerOpt= customerDao.findById(userId);
			Wallet wallet = customerOpt.get().getWallet();
			
			List<BeneficiaryDetail> list=wallet.getBeneficiaryDetails();
			list.add(beneficiaryDetail);
			
			wDao.save(wallet);
			return bDao.save(beneficiaryDetail);
			
			
		}else {
			throw new BeneficiaryDetailException("You have to login first");
		}
		
	}

	@Override
	public BeneficiaryDetail deleteBeneficiary(BeneficiaryDetail beneficiaryDetail,String mobile) throws BeneficiaryDetailException {
		Optional<CurrentSessionUser> curentSessionOpt= sDao.findByMobileNo(mobile);
		if(curentSessionOpt.isPresent()){
			CurrentSessionUser user=curentSessionOpt.get();
			int userId=user.getUserId();
			
			Optional<Customer> customerOpt= customerDao.findById(userId);
			Wallet wallet = customerOpt.get().getWallet();
			
			List<BeneficiaryDetail> list=wallet.getBeneficiaryDetails();
			if(list.remove(beneficiaryDetail)) {
					wDao.save(wallet);
					bDao.delete(beneficiaryDetail);
					return beneficiaryDetail;
			}else {
				throw new BeneficiaryDetailException("Some technical glitch");
			}
			
		}else {
			throw new BeneficiaryDetailException("You have to login first");
		}
	}

	@Override
	public BeneficiaryDetail viewBeneficiaryByMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException {
		BeneficiaryDetail beneficiaryDetail=bDao.findBybeneficiaryMobileNo(beneficiaryMobileNo);
		if(beneficiaryDetail == null) {
			throw new BeneficiaryDetailException("No Beneficiary found with Mobile No : "+beneficiaryMobileNo);
		}else {
			return beneficiaryDetail;
		}
	}

	@Override
	public List<BeneficiaryDetail> viewAllBeneficiary(Customer customer) throws BeneficiaryDetailException {
		List<BeneficiaryDetail> list = customer.getWallet().getBeneficiaryDetails();
		if(list.isEmpty()) {
			throw new BeneficiaryDetailException("No Beneficiary found with id : "+customer.getUserId());
		}else {
			return list;
		}
	}

}
