package com.bnking.bussinessLayer;


public class AccountManagerFactory {
	
	static IAccountManager account;
	static SavingsAccountManager savingsAccount=new SavingsAccountManager();
	static CurrentAccountManager currentAccountManager=new CurrentAccountManager();
	public static IAccountManager Create(IAccountManager accountType){
		
		if(accountType==savingsAccount)
			account= savingsAccount;
		else 
			account= currentAccountManager;
		return account;
	}

}
