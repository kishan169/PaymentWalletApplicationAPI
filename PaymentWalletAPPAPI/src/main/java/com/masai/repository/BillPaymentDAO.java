package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.masai.model.BillPayment;

@Service
public interface BillPaymentDAO extends JpaRepository<BillPayment, Integer> {

}
