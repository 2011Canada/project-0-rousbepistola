package com.worldbank.services;

import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;
import com.worldbank.models.Customer;

public class CustomerServices {
	int option;
	
	Scanner scan = new Scanner(System.in);
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	AccountServices accountServices = new AccountServices();
	
	String fname;
	String lname;
	String username;
	String pass;
	int user_id;
	String userType;
	String account;
	Customer customer;
	
	
	

	public void CustomerMain(String[] credentials) {
		this.fname = credentials[0];
		this.lname = credentials[1];
		this.username = credentials[2];
		this.pass = credentials[3];;
		this.user_id = Integer.parseInt(credentials[4]);
		this.userType = "customer";
//		customer = new Customer(fname, lname, username, pass, user_id, userType, account);
		
		System.out.print(credentials[0] + " " + credentials[1] + "\nUnique Account Identification: " + credentials[4]);
		System.out.println("");
		primary(credentials);
		
	}
	
	
	
	
	
	
	public void primary(String[] credentials) {
		option = customerOptions();
		
		if(option == 1) {
			accountServices.viewBalance(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 2) {
			accountServices.wdraw(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 3) {
			accountServices.deposit(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 4) {
			accountServices.transfer(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 5) {
			accountServices.receiveTransfers(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 6) {
			accountServices.createNewAccount(credentials);
			CustomerMain(credentials);
		}
		
		if(option == 0) {
			logout();
		}
		
	};
	
	
	
	
	
	
	
	
	public int customerOptions() {
		
		System.out.println("1 : View Balance");
		System.out.println("2 : Withdraw");
		System.out.println("3 : Deposit");
		System.out.println("4 : Transfers");
		System.out.println("5 : Receive Transfers");
		System.out.println("6 : Create New Banking Account");
		System.out.println("0 : Logout");
		
		System.out.println("");
		System.out.print("ENTER SELECTION : ");
		
		
		


		 while (!scan.hasNextInt()) {
		      System.out.println("Input is not a number. Try Again");
		      scan.nextLine();
		    }
		
		option = this.scan.nextInt();
		mainMenu.clearConsole(15);
		
		
		if(option < 0 || option >= 7) {
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
