package com.worldbank.services;

import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;
import com.worldbank.models.Customer;

public class EmployeeServices {

	int option;
	
	Scanner scan = new Scanner(System.in);
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	ExecutiveServices executive = new ExecutiveServices();
	
	
	int user_id;
	String fname;
	String lname;
	String username;
	String pass;
	
	
	public void CustomerMain(String[] credentials) {
		this.fname = credentials[0];
		this.lname = credentials[1];
		this.username = credentials[2];
		this.pass = credentials[3];;
		this.user_id = Integer.parseInt(credentials[4]);


		
		System.out.print(credentials[0] + " " + credentials[1]);
		System.out.println("");
		primary(credentials);
		
	}
	
	
	
	
	
	public void primary(String[] credentials) {
		option = customerOptions();
		
		if(option == 1) {
			executive.accountApproval(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 2) {
			executive.viewAccount(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 3) {
			executive.viewLogs(credentials);
			CustomerMain(credentials);
		}

		
		if(option == 0) {
			logout();
		}
		
	};
	
	
	
	
	
	
	
	
	public int customerOptions() {
		
		System.out.println("1 : Approve Pending Accounts");
		System.out.println("2 : View Customer Bank Account");
		System.out.println("3 : View Transaction Logs");
		System.out.println("0 : Logout");

		
		System.out.println("");
		System.out.print("ENTER SELECTION : ");
		
		
		


		 while (!scan.hasNextInt()) {
		      System.out.println("Input is not a number. Try Again");
		      scan.nextLine();
		    }
		
		option = this.scan.nextInt();
		mainMenu.clearConsole(15);
		
		
		if(option < 0 || option >= 4) {
			mainMenu.clearConsole(20);
			System.out.println("Invalid selection, please try again");
			customerOptions();
			
		}

		return option;
	}
	
	
	public void logout() {
		mainMenu.clearConsole(35);
		mainMenu.welcomeToWorldBank();
		System.out.println("You successfully logged out!");
		System.out.println("Thank you for using our service");
	}
	
	


	


	
	
	
	
	
	

}
