package com.masai.service;

import java.util.List;

import com.masai.exception.BillPaymentException;
import com.masai.model.BillPayment;

public interface BillPaymentService {
	
	public BillPayment addBillPayment(BillPayment payment) throws BillPaymentException;
	public List<BillPayment> viewBillPayment() throws BillPaymentException;

}
