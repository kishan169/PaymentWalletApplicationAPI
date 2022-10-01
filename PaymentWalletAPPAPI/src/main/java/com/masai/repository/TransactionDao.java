package com.masai.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Transaction;
import com.masai.model.TransactionType;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{
	
//	@Query("select t from transaction t where t.transactionDate between ?1 and ?2")
//	public List<Transaction> getTransactionByTransactionType(LocalDateTime to,LocalDateTime from);
	
	
//	@Query("select t from transaction t where t.transactionType=?1")
	public List<Transaction> getTransactionByTransactionType(TransactionType type);

}
