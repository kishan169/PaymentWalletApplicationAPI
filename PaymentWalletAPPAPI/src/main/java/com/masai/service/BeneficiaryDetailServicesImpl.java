package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.repository.BeneficiaryDetailDao;
@Service
public class BeneficiaryDetailServicesImpl implements BeneficiaryDetailServices{
	@Autowired
	private BeneficiaryDetailDao bDao;
	@Override
	public BeneficiaryDetail addBeneficiary(BeneficiaryDetail bd) throws BeneficiaryDetailException {
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
