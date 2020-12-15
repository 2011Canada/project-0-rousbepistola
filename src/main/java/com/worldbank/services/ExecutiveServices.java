package com.worldbank.services;

import java.util.ArrayList;

import com.worldbank.models.Account;
import com.worldbank.repositories.EmployeeServicesDao;


public class ExecutiveServices {
	
	EmployeeServicesDao esd = new EmployeeServicesDao();

	public void accountApproval(String[] credentials){
		System.out.println("\n\n\n");
		ArrayList<Account> balance = esd.approveAccount(credentials);

		if(balance.size() == 0) {
			System.out.println("Nothing to approve");
		}
		
		System.out.println("\n\n\n");
	}
	
	
	
	
	
	public void viewAccount(String[] credentials){
		ArrayList<Account> balance = esd.customerViewBalance(credentials);
		System.out.println("\n\n\n");
		System.out.println("ACCOUNT BALANCE:");

		
		for (int i = 0; i < balance.size(); i++) {
			System.out.println(balance.get(i).getAccount_name() + " " + balance.get(i).getBalance());
		}
		System.out.println("\n\n\n");
	}
	
	
	
	
	
	
	
	public void viewLogs(String[] credentials){
		System.out.println("Viewed logs\n\n\n");
	}
	
}
