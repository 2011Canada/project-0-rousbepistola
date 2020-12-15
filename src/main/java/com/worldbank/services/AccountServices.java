package com.worldbank.services;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.worldbank.models.Account;
import com.worldbank.models.Transfers;
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
		ArrayList<Account> transfer = wbpd.customerTransfer(credentials);
		System.out.println("Transfer Initialized. \nShare the transfer Password and account number where you deposited the money \nto the account owner for them to receive the money");
		System.out.println("\n\n\n");
	};
	
//	RECEIVE TRANSFERS
	public void receiveTransfers(String[] credentials) {
		ArrayList<Transfers> receivedTransfer = wbpd.receiveTransfer(credentials);
		System.out.println("Transactions might have delays. Check again at a later time if expected tansaction is not available");
		System.out.println("\n\n\n");
		
	}
	
//	CREATE NEW ACCOUNT
	public void createNewAccount(String[] credentials) {
		int createAccount = wbpd.createAccount(credentials);
		System.out.println("Account Creation Request Initiated\n\n\n");
	}


}
