package com.claimaster.utils.enumerations;

public enum PaymentInfo {
			
	CARD_NUMBER  ("4591150277136370"),
	MONTH        (01),
	YEAR         (2021),
	CVV          (1234);		
		
	private String stringValue;
	private int intValue;
	 
	private PaymentInfo(String value) {
		this.stringValue = value;
	}
	
	private PaymentInfo(int value) {
		this.intValue = value;
	}
	
	@Override
	public String toString() {
		return stringValue;
	}

	 public int getValue() {
	        return intValue;
	    }
}
