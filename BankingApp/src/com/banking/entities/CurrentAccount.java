package com.banking.entities;

public class CurrentAccount extends Account{
	
	private String companyName;
	private String website;
	private int registrationNo;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getRegistrationNumber() {
		return registrationNo;
	}
	public void setRegistrationNumber(int registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	

}
