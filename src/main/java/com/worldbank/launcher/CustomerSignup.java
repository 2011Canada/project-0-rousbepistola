package com.worldbank.launcher;

import java.io.Console;
import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;
import com.worldbank.repositories.WorldBankPostgresDao;

public class CustomerSignup {
	
	String fname;
	String lname;
	String username;
	String pass;
	
	String[] login = new String[5];
	
	Scanner signupScan = new Scanner(System.in);
	Console console = System.console(); // will be used possibly later once we know how to get password from console.
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	
	WorldBankPostgresDao wbpd = new WorldBankPostgresDao();
	
//	methods
	
	public String[] customerSignup() {
		
		System.out.println("");
		System.out.println("          COMPLETE THE FIELDS BELOW          ");
		System.out.println("");
		System.out.print("FIRST NAME: ");
		fname = signupScan.nextLine();
		System.out.print("LAST NAME: ");
		lname = signupScan.nextLine();
		System.out.print("USERNAME: ");
		username = signupScan.nextLine();
		System.out.print("PASSWORD: "); 
		pass = signupScan.nextLine();
		mainMenu.clearConsole(10);

		
		login[0] = username;
		login[1] = pass;
		login[2] = fname;
		login[3] = lname;
		
		String[] customerCredential = wbpd.customerSignup(login);
//		System.out.println(customerCredential[0]);
		
//		if(customerCredential[0].equals("false")) {
//			System.out.println("Signup Unsuccesful");
//			customerSignup();
//		} else {
//			customerCredential = wbpd.customerLogin(login);
//			return customerCredential;
//		}
		customerCredential = wbpd.customerLogin(login);
		return customerCredential;
		
	}

	}
	



