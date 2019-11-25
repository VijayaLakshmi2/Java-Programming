package com.bnking.bussinessLayer;

import com.banking.entities.Account;
import com.banking.entities.Transaction;
import com.banking.entities.TransactionLog;

public abstract class AccountManager implements IAccountManager{

	TransactionLog transactionLog; 
	Transaction transaction;
	
	public abstract Account open(Account account);
	
	@Override
	public void withdraw(Account account, int balance) {
		// TODO Auto-generated method stub
		account.setBalance(account.getBalance()-balance);
		transactionLog.addTransaction(transaction);
		
	}

	@Override
	public void deposite(Account account, int balance) {
		// TODO Auto-generated method stub
		account.setBalance(account.getBalance()+balance);
		
	}

	public abstract Account close(Account account);

}
