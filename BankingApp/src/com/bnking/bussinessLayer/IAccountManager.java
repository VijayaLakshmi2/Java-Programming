package com.bnking.bussinessLayer;

import com.banking.entities.Account;

public interface IAccountManager {
	
	Account open(Account account);
	void withdraw(Account account, int balance);
	void deposite(Account account, int balance);
	Account close(Account account);
}
