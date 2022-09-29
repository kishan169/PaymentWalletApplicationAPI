package com.masai.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Wallet {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
//	wallet.setBalance(0.0);
//	wallet.setCustomer(newSignUp);
//	walletDao.save(wallet);
//	newSignUp.setWallet(wallet);
	
	
	@Min(value = 0)
	private Double balance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToMany
	@JsonIgnore
	private Set<Transaction> transaction;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private BankAccount bankAccount;
	
	@OneToMany
	@JsonIgnore
	private List<BillPayment> billPayment;
	
	@Embedded
	@ElementCollection
	@JsonIgnore
	private List<BeneficiaryDetail> beneficiaryDetails;
	
	
	//=======================================================================================================

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<BillPayment> getBillPayment() {
		return billPayment;
	}

	public void setBillPayment(List<BillPayment> billPayment) {
		this.billPayment = billPayment;
	}

	public List<BeneficiaryDetail> getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(List<BeneficiaryDetail> beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + ", customer=" + customer + ", transaction="
				+ transaction + ", bankAccount=" + bankAccount + ", billPayment=" + billPayment
				+ ", beneficiaryDetails=" + beneficiaryDetails + "]";
	}

	public Wallet(Integer walletId, Double balance, Customer customer, Set<Transaction> transaction,
			BankAccount bankAccount, List<BillPayment> billPayment, List<BeneficiaryDetail> beneficiaryDetails) {
		super();
		this.walletId = walletId;
		this.balance = balance;
		this.customer = customer;
		this.transaction = transaction;
		this.bankAccount = bankAccount;
		this.billPayment = billPayment;
		this.beneficiaryDetails = beneficiaryDetails;
	}

	
	
	
}
