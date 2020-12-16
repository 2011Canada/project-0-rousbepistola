package com.worldbank.services;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worldbank.models.Account;
import com.worldbank.repositories.EmployeeServicesDao;



public class ExecutiveServicesTest {
	
	
private EmployeeServicesDao ed = mock(EmployeeServicesDao.class) ;
private ExecutiveServices es = mock(ExecutiveServices.class);
	
	@BeforeEach
	public void setupMyEmpSercices() {
		this.ed = new EmployeeServicesDao(); 
	}
		

	
//	should return logs of all transactions
	@Test
	public void viewLogsTest() {
		es = new ExecutiveServices();
		String[] credentials = new String[2];
		credentials[0] = "admin";
		credentials[1] = "admin";
		try {
			es.viewLogs(credentials);
		} finally {
			es.viewLogs(credentials);
		}
	}
	
	
	@Test
	public void viewAccountTest() {
		String[] credentials = new String[2];
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		credentials[0]="Rous";
		credentials[1]="Epistola";
		
		accounts.add(new Account(1, "checking", 10000, 1));
		accounts.add(new Account(1, "savings", 10000, 2));
		accounts.add(new Account(1, "charity", 10000, 3));
		
		assertEquals(accounts.size(), ed.customerViewBalance(credentials).size(), "are they equal");

		
		
		
		
	}
	

}



