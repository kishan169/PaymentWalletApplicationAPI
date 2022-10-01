package com.masai.repository;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{
	
	@Query("select t from Transaction t where t.transaction_date > start and t.transaction_date < end")
	public Set<Transaction> findByDateRange(LocalDate start, LocalDate end);
}
