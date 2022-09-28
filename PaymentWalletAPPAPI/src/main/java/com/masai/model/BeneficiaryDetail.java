package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BeneficiaryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	
	private String beneficiaryName;
	
	private String beneficiaryMobileNo;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Wallet wallet;
}
