package com.worldbank.launcher;

import com.worldbank.menu.*;

public class WorldBankLauncher {

	public static void main(String[] args) throws InterruptedException {
		
		MainMenuLauncher mainMenu = new MainMenuLauncher();
		EmployeeLogin eLogin = new EmployeeLogin();
		
		mainMenu.welcomeToWorldBank();
		int result = mainMenu.homeSelection(); // gets 1 2 3 or 4 depending on their input
		System.out.println(result);
		
		//PASS MAIN MENU - We can present customer login or Employee Login
		
		
		
		//1 -- CUSTOMER LOGIN
		
		
		
		//2 -- EMPLOYEE LOGIN
		mainMenu.clearConsole(25);
		mainMenu.welcomeToEmployeeLogin();
		String[] employeeLoginCredentials = eLogin.employeeLogin(); // <-- RETURNS EMPLOYEE USERNAME OR PASSWORD
		mainMenu.loading(50);
		mainMenu.clearConsole(50);

		
		
		

	}

}
