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

@Entity
public class BeneficiaryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	@NotNull
	@NotBlank
	private String beneficiaryName;
	@NotNull
	@NotBlank
	@Min(10)
	@Max(10)
	private String beneficiaryMobileNo;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Wallet wallet;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public BeneficiaryDetail(Integer beneficiaryId, @NotNull @NotBlank String beneficiaryName,
			@NotNull @NotBlank @Min(10) @Max(10) String beneficiaryMobileNo, Customer customer, Wallet wallet) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryMobileNo = beneficiaryMobileNo;
		this.customer = customer;
		this.wallet = wallet;
	}

	public BeneficiaryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
