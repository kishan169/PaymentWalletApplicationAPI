package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.BillPaymentException;
import com.masai.model.BillPayment;
import com.masai.repository.BillPaymentDAO;

public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentDAO dao;

	@Override
	public BillPayment addBillPayment(BillPayment payment) throws BillPaymentException {
		
		BillPayment addBP=dao.save(payment);	
		
		
		return addBP;
	}

	@Override
	public List<BillPayment> viewBillPayment() throws BillPaymentException {
		
		List<BillPayment> viewBP=dao.findAll();
		
		if(viewBP.size()!=0) return viewBP;
		
		else throw new BillPaymentException("No details found ...");
		
	}

}
