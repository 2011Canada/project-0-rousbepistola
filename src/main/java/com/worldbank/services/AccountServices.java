package com.worldbank.services;

import java.util.ArrayList;

import com.worldbank.models.Account;
import com.worldbank.repositories.WorldBankPostgresDao;

public class AccountServices {
	
	WorldBankPostgresDao wbpd = new WorldBankPostgresDao();

	
//	VIEW BALANCE
	public void viewBalance(String[] credentials) {
		ArrayList<Account> balance = wbpd.customerViewBalance(credentials);
		System.out.println("ACCOUNT BALANCE:");
		for (int i = 0; i < balance.size(); i++) {
			System.out.println(balance.get(i).getAccount_name() + " " + balance.get(i).getBalance());
		}
		System.out.println("\n\n\n");
		
	};
	
	
//	WITHDRAWAL
	public void wdraw(String[] credentials) {
		ArrayList<Account> wdrawBalance = wbpd.customerWithdrawal(credentials);
		System.out.println("WITHDRAWAL SUCCESFUL");
		System.out.println("\n\n\n");
	};
	
	
//	DEPOSIT
	public void deposit(String[] credentials) {
		ArrayList<Account> depositBalance = wbpd.customerDeposit(credentials);
		System.out.println("DEPOSIT SUCCESFUL");
		System.out.println("\n\n\n");
	};
	
	
//	TRANSFERS
	public void transfer(String[] credentials) {
		ArrayList<Account> depositBalance = wbpd.customerDeposit(credentials);
		System.out.println("TRANSFER SUCCESFUL");
		System.out.println("\n\n\n");
	};
	
	
//	CREATE NEW ACCOUNT
	public void createNewAccount(String[] credentials) {
		System.out.println("newaccount");
	}

	

}
