package com.worldbank.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

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
		
		System.out.println("====================TRANSACTION LOGS====================");
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\rousb\\Desktop\\projectWorkspace\\project-0-rousbepistola\\logs\\trace.log"))) {
	        stream.forEach(System.out::println);
	} catch (IOException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println("failed fetching logs\n\n\n");
	}
		System.out.println("====================TRANSACTION ENDS====================\n\n\n\n\n");
		
		
	}
	
}
