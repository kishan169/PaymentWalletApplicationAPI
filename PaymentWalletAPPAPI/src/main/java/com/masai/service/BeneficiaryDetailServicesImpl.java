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
@Service
public class BeneficiaryDetailServicesImpl implements BeneficiaryDetailServices{
	@Autowired
	private BeneficiaryDetailDao bDao;
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	public BeneficiaryDetail addBeneficiary(BeneficiaryDetail bd) throws BeneficiaryDetailException {
		CurrentSessionUser user =  LoginServiceImpl.getCurrentUser();
		
		Optional<Customer> customer = customerDao.findById(user.getUserId());
		
		Wallet wallet = customer.get().getWallet();
		System.out.println(wallet.getWalletId());
		bd.setWalletId(wallet.getWalletId());
		BeneficiaryDetail saved =bDao.save(bd);
		return saved;
	}

	@Override
	public BeneficiaryDetail deleteBeneficiary(BeneficiaryDetail bd) throws BeneficiaryDetailException {
		Optional<BeneficiaryDetail> opt =bDao.findById(bd.getBeneficiaryId());
		if(opt.isPresent()) {
			BeneficiaryDetail detail=opt.get();
			bDao.delete(detail);
			return detail;
		}else {
			throw new BeneficiaryDetailException("No Beneficiary found with id : "+bd.getBeneficiaryId());
		}
		
	}

	@Override
	public BeneficiaryDetail viewBeneficiaryByMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException {
		BeneficiaryDetail bd=bDao.findBybeneficiaryMobileNo(beneficiaryMobileNo);
		if(bd == null) {
			throw new BeneficiaryDetailException("No Beneficiary found with Mobile No : "+beneficiaryMobileNo);
		}else {
			return bd;
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
