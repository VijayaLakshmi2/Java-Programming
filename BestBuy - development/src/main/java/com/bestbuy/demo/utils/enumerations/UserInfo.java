package com.bestbuy.demo.utils.enumerations;

public enum UserInfo {
	FIRST_NAME  ("alex"),
	LAST_NAME   ("siminiuc"),
	ADDRESS     ("200 broadway"),
	CITY        ("vancouver"),	
	PROVINCE    ("BC"),
	POSTAL_CODE ("E4E 0G4"),
	COUNTRY("Canada"),
	PHONE1      ("9999999999"),
	PHONE2      ("123"),
	PHONE3      ("4567");
		
	private String stringValue;
	private int intValue;
	 
	private UserInfo(String value) {
		this.stringValue = value;
	}
	
	private UserInfo(int value) {
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
