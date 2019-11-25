package com.banking.entities;

public class TransactionLog {

	public Transaction transaction;
	
	public void addTransaction(Transaction transaction){
		this.transaction=transaction;
		
	}
	
	public Transaction getTransaction(){
		return transaction;
	}
}
