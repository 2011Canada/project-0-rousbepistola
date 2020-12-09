package com.worldbank.models;

import java.util.ArrayList;

public class Account {

	double balance;
	ArrayList<String> transactions;
	int accountNumber;
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(double balance, ArrayList<String> transactions, int accountNumber) {
		super();
		this.balance = balance;
		this.transactions = transactions;
		this.accountNumber = accountNumber;
	}

	//METHODS
	
	public void transfer() {
		
	};
	
	public void acceptTransfer() {
		
	};
	
	public void viewBalance() {
		
	}

	
	//TO STRING
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber
				+ "]";
	};
	
	
	
	

}
