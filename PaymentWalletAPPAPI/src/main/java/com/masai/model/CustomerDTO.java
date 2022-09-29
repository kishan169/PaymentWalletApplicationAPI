package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerDTO {
	
	private String moblidNo;
	private Integer amount;
	
//	================================
	public String getMoblidNo() {
		return moblidNo;
	}
	public void setMoblidNo(String moblidNo) {
		this.moblidNo = moblidNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public CustomerDTO(String moblidNo, Integer amount) {
		super();
		this.moblidNo = moblidNo;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CustomerDTO [moblidNo=" + moblidNo + ", amount=" + amount + "]";
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
