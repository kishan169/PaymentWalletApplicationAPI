package com.masai.service;

import java.util.List;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;

public interface BeneficiaryDetailServices {
	public BeneficiaryDetail addBeneficiary(BeneficiaryDetail bd) throws BeneficiaryDetailException;
	public BeneficiaryDetail deleteBeneficiary(BeneficiaryDetail bd,String mobile) throws BeneficiaryDetailException;

	public BeneficiaryDetail viewBeneficiaryByMobileNo(String mobNo) throws BeneficiaryDetailException;
	public List<BeneficiaryDetail> viewAllBeneficiary(Customer customer) throws BeneficiaryDetailException;
}
