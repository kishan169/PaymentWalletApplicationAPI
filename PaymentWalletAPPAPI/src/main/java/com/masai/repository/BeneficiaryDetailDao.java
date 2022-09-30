package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;

public interface BeneficiaryDetailDao extends JpaRepository<BeneficiaryDetail, Integer>{

	public BeneficiaryDetail findBybeneficiaryMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException;
	public List<BeneficiaryDetail> findByWalletId(Integer walletId) throws BeneficiaryDetailException;

}
