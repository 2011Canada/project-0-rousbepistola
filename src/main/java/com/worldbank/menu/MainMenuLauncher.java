package com.worldbank.menu;

import java.util.Scanner;

public class MainMenuLauncher {
	
	Scanner loginScan = new Scanner(System.in);
	int mainOption;
	
	public void welcomeToWorldBank() {
		System.out.println("*****************************************");
		System.out.println("*	____             _______        *");
		System.out.println("*	\\   \\    ___    /  / __  )      *");
		System.out.println("*	 \\   \\  /   \\  /  / ___ /       *");
		System.out.println("*	  \\   \\/ / \\ \\/  / __  /        *");
		System.out.println("*	   \\____/   \\___/_____)         *");
		System.out.println("*	     WORLDBANK CONNECT          *");
		System.out.println("*****************************************");

	}
	
	public void welcomeToEmployeeLogin() {
		System.out.println("*****************************************");
		System.out.println("*	       EMPLOYEE LOGIN           *");
		System.out.println("*****************************************");
	}
	
	public void welcomeToCustomerLogin() {
		System.out.println("*****************************************");
		System.out.println("*	       CUSTOMER LOGIN           *");
		System.out.println("*****************************************");
	}
	
	public void welcomeToCustomerSignup() {
		System.out.println("*****************************************");
		System.out.println("*	       CUSTOMER SIGNUP           *");
		System.out.println("*****************************************");
	}
	
	
	//loading
	public void loading(int num) throws InterruptedException {
		for (int i = 0; i < num; ++i) {
			Thread.sleep(50);
			System.out.print("•");
		}
		
		
	}
	
	
	//PSEUDO CLEAR CONSOLE
	public void clearConsole(int num)
	{
		for (int i = 0; i < num; ++i) System.out.println("");
		
	}
	
	
	
	public int homeSelection() {
		
		System.out.println("");
		System.out.println("          How can we direct you?          ");
		System.out.println("");
		System.out.println("1 : Customer Login");
		System.out.println("2 : Employee Login");
		System.out.println("3 : Customer Signup");
		System.out.println("4 : FAQs");
		System.out.println("");
		System.out.print("Input option number: ");
		
	 while (!loginScan.hasNextInt()) {
	      System.out.println("Input is not valid. Try Again");
	      loginScan.nextLine();
	    }
		mainOption = loginScan.nextInt();
		
		
		if(mainOption == (int)mainOption) {
			if(mainOption <= 0 || mainOption > 4 ) {
				clearConsole(50);
				welcomeToWorldBank();
				System.out.println("---------------------INVALID SELECTION-----------------------");
				System.out.println("Your selection is not part of the option. Please choose again");
				homeSelection();
			} else {
				//System.out.println("You chose option " + mainOption);
				return mainOption;
			}
		}
		return mainOption;

	}
	
}


