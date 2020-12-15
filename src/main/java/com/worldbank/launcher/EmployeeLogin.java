package com.worldbank.launcher;

import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;
import com.worldbank.repositories.WorldBankPostgresDao;

import java.io.Console;

public class EmployeeLogin {
	
	String username;
	String pass;
	String[] login = new String[2];
	
	Scanner loginScan = new Scanner(System.in);
	Console console = System.console();
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	
	WorldBankPostgresDao wbpd = new WorldBankPostgresDao();
	
	public String[] employeeLogin() {
		
		System.out.println("");
		System.out.println("          Login with username and password          ");
		System.out.println("");
		System.out.print("USERNAME: ");
		username = loginScan.nextLine();
		System.out.print("PASSWORD: ");
		pass = loginScan.nextLine();
		mainMenu.clearConsole(20);

		

		login[0] = username;
		login[1] = pass;

		
		String[] employeeCredential = wbpd.employeeLogin(login);
//		System.out.println(customerCredential[0]);
		
		if(employeeCredential[0].equals("false")) {
			System.out.println("Username or Password may be incorrect or does not exist. Please try again");
			employeeCredential[0] = null;
			employeeLogin();
		} else {
			employeeCredential = wbpd.employeeLogin(login);
			return employeeCredential;
		}
		employeeCredential = wbpd.employeeLogin(login);
		return employeeCredential; 
	}

	

}

