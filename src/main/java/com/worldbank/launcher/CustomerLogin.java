package com.worldbank.launcher;

import java.io.Console;
import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;
import com.worldbank.repositories.WorldBankPostgresDao;

public class CustomerLogin {
	
	String username;
	String pass;
	
	String[] login = new String[2];
	
	Scanner loginScan = new Scanner(System.in);
	Console console = System.console(); // will be used possibly later once we know how to get password from console.
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	
	WorldBankPostgresDao wbpd = new WorldBankPostgresDao();
	
//	methods
	
	public String[] customerLogin() {
		
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
		
		String[] customerCredential = wbpd.customerLogin(login);
//		System.out.println(customerCredential[0]);
		
		if(customerCredential[0].equals("false")) {
			System.out.println("Username or Password may be incorrect or does not exist. Please try again");
			customerCredential[0] = null;
			customerLogin();
		} else {
			customerCredential = wbpd.customerLogin(login);
			return customerCredential;
		}
		customerCredential = wbpd.customerLogin(login);
		return customerCredential; // returns fname lname username pass user_id from index 0
		
	}
	
	

}
