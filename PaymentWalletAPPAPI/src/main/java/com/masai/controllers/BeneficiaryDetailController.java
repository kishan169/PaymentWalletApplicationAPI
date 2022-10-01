package com.masai.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.service.BeneficiaryDetailServices;
import com.masai.service.LoginServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class BeneficiaryDetailController {
	
	@Autowired
	private BeneficiaryDetailServices bSer;
	
	@PostMapping("ben")
	public ResponseEntity<BeneficiaryDetail> addBeneficiaryDetail(@RequestBody BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException{
		BeneficiaryDetail saved = bSer.addBeneficiary(beneficiaryDetail);
		return new ResponseEntity<BeneficiaryDetail>(saved,HttpStatus.CREATED);
	}
	@PatchMapping("ben/del")
	public ResponseEntity<BeneficiaryDetail>deleteBeneficiaryDetail(@RequestParam String mobileNo,@RequestParam String beneficiaryMobileNo) throws BeneficiaryDetailException{
		System.out.println(mobileNo);
		System.out.println(beneficiaryMobileNo);
		BeneficiaryDetail deleted = bSer.deleteBeneficiary(mobileNo,beneficiaryMobileNo);
		return new ResponseEntity<BeneficiaryDetail>(deleted,HttpStatus.OK);
	}
	@GetMapping("ben/{beneficiaryMobileNo}")
	public ResponseEntity<BeneficiaryDetail>findBeneficiaryDetailByMobNo(@PathVariable("beneficiaryMobileNo") String MobNo) throws BeneficiaryDetailException{
		BeneficiaryDetail beneficiaryDetail = bSer.viewBeneficiaryByMobileNo(MobNo);
		return new ResponseEntity<BeneficiaryDetail>(beneficiaryDetail,HttpStatus.OK);
	}
	@PostMapping("ben/customer")
	public ResponseEntity<List<BeneficiaryDetail>>findBeneficiaryDetailByCustomer(@RequestBody Customer customer) throws BeneficiaryDetailException{
		List<BeneficiaryDetail> list = bSer.viewAllBeneficiary(customer);
		return new ResponseEntity<List<BeneficiaryDetail>>(list,HttpStatus.OK);
	}
}
