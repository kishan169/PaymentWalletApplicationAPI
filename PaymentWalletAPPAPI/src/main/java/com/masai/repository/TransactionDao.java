package com.masai.repository;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Set;
=======
import java.time.LocalDateTime;
import java.util.*;
>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Transaction;
import com.masai.model.TransactionType;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{
	
<<<<<<< HEAD
	@Query("select t from Transaction t where t.transaction_date > start and t.transaction_date < end")
	public Set<Transaction> findByDateRange(LocalDate start, LocalDate end);
=======
//	@Query("select t from transaction t where t.transactionDate between ?1 and ?2")
//	public List<Transaction> getTransactionByTransactionType(LocalDateTime to,LocalDateTime from);
	
	
//	@Query("select t from transaction t where t.transactionType=?1")
	public List<Transaction> getTransactionByTransactionType(TransactionType type);

>>>>>>> 2d1825baeeb2a90f6a1c3852c09c898da285f5f2
}
