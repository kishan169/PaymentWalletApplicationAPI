package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.service.BeneficiaryDetailServices;

@RestController
public class BeneficiaryDetailController {
	@Autowired
	private BeneficiaryDetailServices bSer;
	
	@PostMapping("ben/add")
	public ResponseEntity<BeneficiaryDetail>addBeneficiaryDetail(@RequestBody BeneficiaryDetail bd) throws BeneficiaryDetailException{
		BeneficiaryDetail saved = bSer.addBeneficiary(bd);
		return new ResponseEntity<BeneficiaryDetail>(saved,HttpStatus.CREATED);
	}
	@PostMapping("ben/del")
	public ResponseEntity<BeneficiaryDetail>deleteBeneficiaryDetail(@RequestBody BeneficiaryDetail bd) throws BeneficiaryDetailException{
		BeneficiaryDetail deleted = bSer.deleteBeneficiary(bd);
		return new ResponseEntity<BeneficiaryDetail>(deleted,HttpStatus.OK);
	}
	@GetMapping("ben/{}")
	public ResponseEntity<BeneficiaryDetail>findBeneficiaryDetailByMobNo(@PathVariable String MobNo) throws BeneficiaryDetailException{
		BeneficiaryDetail bd = bSer.viewBeneficiaryByMobileNo(MobNo);
		return new ResponseEntity<BeneficiaryDetail>(bd,HttpStatus.OK);
	}
	@PostMapping("ben/customer")
	public ResponseEntity<List<BeneficiaryDetail>>findBeneficiaryDetailByCustomer(@RequestBody Customer customer) throws BeneficiaryDetailException{
		List<BeneficiaryDetail> list = bSer.viewAllBeneficiary(customer);
		return new ResponseEntity<List<BeneficiaryDetail>>(list,HttpStatus.OK);
	}
}
