package com.bnking.bussinessLayer;

import com.banking.entities.Account;
import com.banking.entities.CurrentAccount;
import com.banking.entities.SavingsAccount;

public class AccountFactory {
	
	static Account account;
	public static Account Create(String accountType){
		
		if(accountType.equalsIgnoreCase("Savings"))
			account= new SavingsAccount();
		else 
			account= new CurrentAccount();
		return account;
	}

}
