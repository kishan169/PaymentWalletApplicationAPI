package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;


@Entity
public class BillPayment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private BillType billtype;
	
	private TransactionType transactionType;
	
	@DecimalMin(value = "0.1", inclusive = true)
	private Double amount;
	
	private LocalDateTime time;
	
	private Integer walletId;

	/**
	 * @return the billId
	 */
	public Integer getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	/**
	 * @return the billtype
	 */
	public BillType getBilltype() {
		return billtype;
	}

	/**
	 * @param billtype the billtype to set
	 */
	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @return the walletId
	 */
	public Integer getWalletId() {
		return walletId;
	}

	/**
	 * @param walletId the walletId to set
	 */
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}


	
	
	
	
	
}
