package com.masai.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accNo;
	private String mobileNo;
	private String ifscode;
	private String bankName;
	private String bankBalance;
	private Integer walletId;
}
