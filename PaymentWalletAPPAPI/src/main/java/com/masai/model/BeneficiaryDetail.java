package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BeneficiaryDetail {
	
  @Id
	private Integer getBeneficiaryId;
  
	private String beneficiaryMobileNo;
	
	private Integer walletId;

    public Integer getGetBeneficiaryId() {
        return getBeneficiaryId;
    }

    public void setGetBeneficiaryId(Integer getBeneficiaryId) {
        this.getBeneficiaryId = getBeneficiaryId;
    }

    public String getBeneficiaryMobileNo() {
        return beneficiaryMobileNo;
    }

    public void setBeneficiaryMobileNo(String beneficiaryMobileNo) {
        this.beneficiaryMobileNo = beneficiaryMobileNo;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
	
	
	
	
}
