package com.worldbank.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.worldbank.menu.*;
import com.worldbank.repositories.WorldBankPostgresDao;
import com.worldbank.services.CustomerServices;
import com.worldbank.services.EmployeeServices;


public class WorldBankLauncher {
	public static Logger transactionLogs = LogManager.getLogger("com.revature.e720");

	public static void main(String[] args) throws InterruptedException {
		
		transactionLogs.info("\n\n\nBank Server Accessed");
//		Logger transactionLogs = LogManager.getLogger("com.worldbank.transactions"); 
		
		MainMenuLauncher mainMenu = new MainMenuLauncher();
		EmployeeLogin eLogin = new EmployeeLogin();
		CustomerLogin cLogin = new CustomerLogin();
		CustomerSignup cSignup = new CustomerSignup();
		WorldBankPostgresDao wbpd = new WorldBankPostgresDao();
		CustomerServices customerServices = new CustomerServices();
		EmployeeServices employeeServices = new EmployeeServices();
		
		
		// CREDENTIALS
		String[] customerLoginCredentials;
		String[] employeeLoginCredentials;
		String[] customerSignupCredentials;

		
		
		mainMenu.welcomeToWorldBank();
		int result = mainMenu.homeSelection(); // gets 1 2 3 or 4 depending on their input
		System.out.println(result);
		
//---------------------------------------------------------LOGIN SIGNUP LOGIC -------------------------------------------------------------------
		
		switch(result) {
		  case 1: 			//1 -- CUSTOMER LOGIN
			mainMenu.clearConsole(50);
			mainMenu.welcomeToCustomerLogin();
			customerLoginCredentials = cLogin.customerLogin(); // <-- returns fname lname username pass user_id from index 0
			mainMenu.loading(50);
			mainMenu.clearConsole(50);
			mainMenu.welcomeToWorldBank();
			System.out.println("Welcome to your customer account!");
			
			transactionLogs.debug("Customer Logged In: " + customerLoginCredentials[0] +" "+ customerLoginCredentials[1]);
//			transactionLogs.info("Customer Logged In: ");
			
			customerServices.CustomerMain(customerLoginCredentials);
			mainMenu.clearConsole(10);
		    break;	
			
		  
		  case 2:			//2 -- EMPLOYEE LOGIN
			mainMenu.clearConsole(50);
			mainMenu.welcomeToEmployeeLogin();;
			employeeLoginCredentials = eLogin.employeeLogin(); // <-- RETURNS EMPLOYEE USERNAME OR PASSWORD
			mainMenu.loading(50);
			mainMenu.clearConsole(50);
			mainMenu.welcomeToWorldBank();
			System.out.println("Welcome to your employee account!");
			transactionLogs.debug("Employee Logged In: " + employeeLoginCredentials[0] +" "+ employeeLoginCredentials[1]);
			employeeServices.CustomerMain(employeeLoginCredentials);
			mainMenu.clearConsole(10);
		    break;
		  
		  case 3: 			// 3 -- CUSTOMER SIGNUP
			mainMenu.clearConsole(50);
			mainMenu.welcomeToCustomerSignup();
			customerSignupCredentials = cSignup.customerSignup(); // <-- RETURNS EMPLOYEE USERNAME OR PASSWORD
			mainMenu.loading(50);
			mainMenu.clearConsole(50);
			mainMenu.welcomeToWorldBank();
			System.out.println("Welcome to your new customer account!");
			transactionLogs.debug("Customer Signed Up: " + customerSignupCredentials[0] +" "+ customerSignupCredentials[1]);
			customerServices.CustomerMain(customerSignupCredentials);
			mainMenu.clearConsole(10);
		    break;
		  
		  case 4: //4 -- FAQs
			mainMenu.clearConsole(50);
			mainMenu.welcomeToWorldBank();
			System.out.println("Am I still alive? : YES\n\nThank you");
		    break;
		  default:
			  mainMenu.welcomeToWorldBank();
		}
		

		
//		------------------------------------------------------------END OF LOGIN / SIGNUP ----------------------------------------------------------

}
}
