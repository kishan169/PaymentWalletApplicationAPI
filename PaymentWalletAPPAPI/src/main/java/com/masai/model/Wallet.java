package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Wallet {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	private Double balance;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany
	@JsonIgnore
	private List<Transaction> transaction;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount bankAccount;
	
	@OneToMany
	private List<BillPayment> billPayment;
	
	@Embedded
	@ElementCollection
	@JsonIgnore
	private List<BeneficiaryDetail> beneficiaryDetails;

}
