package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount {
	
	@Id
	private Integer accountNumber;

	@NotNull
	private String mobileNumber;
	
	@NotNull
	private String ifscCode;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private double bankBalance;
	
	private Integer walletId;
}
