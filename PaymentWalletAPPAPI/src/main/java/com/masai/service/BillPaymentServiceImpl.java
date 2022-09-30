package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.BillPayment;
import com.masai.repository.BillPaymentDao;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{
	
	@Autowired
	private BillPaymentDao billDao;

	@Override
	public BillPayment addbillPayment(BillPayment billpayment) {
		
		billpayment.setWalletId(8);
		System.out.println(billpayment);
		return billDao.save(billpayment);
	}
	
}
