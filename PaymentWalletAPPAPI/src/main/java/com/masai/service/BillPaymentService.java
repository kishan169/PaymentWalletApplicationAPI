package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.BillPayment;

public interface BillPaymentService {
	
	public BillPayment PayBill(BillPayment billpayment,String key) throws LoginException;
	
	
}
