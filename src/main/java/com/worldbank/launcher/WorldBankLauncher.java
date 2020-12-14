package com.worldbank.launcher;

import com.worldbank.menu.*;
import com.worldbank.repositories.WorldBankPostgresDao;
import com.worldbank.services.CustomerServices;


public class WorldBankLauncher {

	public static void main(String[] args) throws InterruptedException {
		
		MainMenuLauncher mainMenu = new MainMenuLauncher();
		EmployeeLogin eLogin = new EmployeeLogin();
		CustomerLogin cLogin = new CustomerLogin();
		CustomerSignup cSignup = new CustomerSignup();
		WorldBankPostgresDao wbpd = new WorldBankPostgresDao();
		CustomerServices customerServices = new CustomerServices();
		
		
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
			mainMenu.clearConsole(10);
		    break;
		  
		  case 4: //4 -- FAQs
			mainMenu.clearConsole(50);
			mainMenu.welcomeToWorldBank();
			System.out.println("NO FAQS QUESTION FOR NOW");
		    break;
		  default:
			  mainMenu.welcomeToWorldBank();
		}
		

		
//		------------------------------------------------------------END OF LOGIN / SIGNUP ----------------------------------------------------------

}
}
