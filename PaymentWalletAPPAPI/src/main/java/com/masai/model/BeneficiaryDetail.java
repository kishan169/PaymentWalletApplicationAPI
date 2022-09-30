package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BeneficiaryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	
	private String beneficiaryName;
  
	private String beneficiaryMobileNo;
	
	private Integer walletId;
	
	
	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryMobileNo() {
		return beneficiaryMobileNo;
	}

	public void setBeneficiaryMobileNo(String beneficiaryMobileNo) {
		this.beneficiaryMobileNo = beneficiaryMobileNo;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}


	public BeneficiaryDetail(Integer beneficiaryId, String beneficiaryName, String beneficiaryMobileNo,
			Integer walletId) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryMobileNo = beneficiaryMobileNo;
		this.walletId = walletId;
	}

	public BeneficiaryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
