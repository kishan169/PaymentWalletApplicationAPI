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
	public BeneficiaryDetail addBeneficiary(BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException {
		CurrentSessionUser user =  LoginServiceImpl.getCurrentUser();
		
		Optional<Customer> customer = customerDao.findById(user.getUserId());
		if(customer.isPresent()) {
		Wallet wallet = customer.get().getWallet();
		System.out.println(wallet.getWalletId());
		BeneficiaryDetail saved =bDao.save(bd);
		beneficiaryDetail.setWalletId(wallet.getWalletId());
		List<BeneficiaryDetail> list = wallet.getBeneficiaryDetails();
		list.add(beneficiaryDetail);
		BeneficiaryDetail saved =bDao.save(beneficiaryDetail);

		return saved;
		}else {
			throw new BeneficiaryDetailException("You need to login first!");
		}
	}

	@Override
	public BeneficiaryDetail deleteBeneficiary(String customerMobile,String benficiaryMobile) throws BeneficiaryDetailException {
		Optional<Customer> customerOption=customerDao.findByMobileNo(customerMobile);
		if(customerOption.isPresent()) {
			Customer customer = customerOption.get();
			Wallet wallet=customer.getWallet();
			
			List<BeneficiaryDetail>list = bDao.findByWalletId(wallet.getWalletId());
			if(list.isEmpty()){
				throw new BeneficiaryDetailException("Wallet is empty");
			}else {
				int index=-1;
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getBeneficiaryMobileNo().equals(benficiaryMobile)) {
						index=i;
						break;
					}
				}
				if(index==-1) throw new BeneficiaryDetailException("Beneficiary Not found with Mobile No "+benficiaryMobile);
				BeneficiaryDetail beneficiaryDetail=list.get(index);
				System.out.println(beneficiaryDetail.getBeneficiaryMobileNo());
				System.out.println(index);
				BeneficiaryDetail updated=list.remove(index);
				wallet.setBeneficiaryDetails(list);
				bDao.delete(updated);
				
				return beneficiaryDetail;
				
			}
			
		}else {
			throw new BeneficiaryDetailException("No Customer found with the mobile no "+customerMobile);
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
		Optional<Customer> customerOpt=customerDao.findByMobileNo(customer.getMobileNo());
		if(customerOpt.isPresent()) {
			Customer existingCustomer=customerOpt.get();
			List<BeneficiaryDetail> list = existingCustomer.getWallet().getBeneficiaryDetails();
			if(list.isEmpty()) {
				throw new BeneficiaryDetailException("No Beneficiary found with id : "+existingCustomer.getUserId());
			}else {
				return list;
			}
		}
		else {
			throw new BeneficiaryDetailException("No customer found");	
		}
	}



}
