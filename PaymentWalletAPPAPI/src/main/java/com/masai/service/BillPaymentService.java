package com.masai.service;

import com.masai.exception.BillPaymentException;
import com.masai.model.BillPayment;

public interface BillPaymentService {
	
	public BillPayment PayBill(BillPayment payment,String key) throws BillPaymentException;
//	public BillPayment viewBillPayment(Integer billId) throws BillPaymentException;

}
