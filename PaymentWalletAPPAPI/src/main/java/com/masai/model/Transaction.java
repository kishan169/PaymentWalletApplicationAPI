package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	@Size(min = 3)
	private String transactiontype;
	
	private LocalDateTime localdatetime;
	
	@Min(value = 0)
	private Double transactionamount;
	
	@Size(min = 3)
	@JsonIgnore
	private String description;
	
	@NotNull
	private Integer walletId;
	
	

	
	//======================================

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	public Double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(Double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Transaction(Integer transactionId, @Size(min = 3) String transactiontype, LocalDateTime localdatetime,
			@Min(0) Double transactionamount, @Size(min = 3) String description, @NotNull Integer walletId) {
		super();
		this.transactionId = transactionId;
		this.transactiontype = transactiontype;
		this.localdatetime = localdatetime;
		this.transactionamount = transactionamount;
		this.description = description;
		this.walletId = walletId;
	}

	public Transaction() {
		this.localdatetime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactiontype=" + transactiontype
				+ ", localdatetime=" + localdatetime + ", transactionamount=" + transactionamount + ", description="
				+ description + ", walletId=" + walletId + "]";
	}
	
	
	
	
}
