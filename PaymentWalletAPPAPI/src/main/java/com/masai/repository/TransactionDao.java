package com.masai.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{
	
	public Set<Transaction> findByWalletId(Integer walletId);
}
