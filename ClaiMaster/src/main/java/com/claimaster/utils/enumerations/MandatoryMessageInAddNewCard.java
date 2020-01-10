package com.claimaster.utils.enumerations;

public enum MandatoryMessageInAddNewCard {

	CARDNUMBER ("Please enter a valid credit card number."), 
	MONTH ("Please select your card's expiry month."), 
	YEAR ("Please select your card's expiry year."), 
	FIRSTNAME ("Please enter your first name."), 
	LASTNAME ("Please enter your last name."), 
	ADDRESS ("Please enter a valid address."), 
	CITY("Please enter a valid city."),
	PROVINCE("Please select a province."),
	POSTALCODE("Please enter a valid postal code."),
	PHONENUMBER("Please enter a 10-digit phone number, including the area code.");
	
	private String value;
	 
	private MandatoryMessageInAddNewCard(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
