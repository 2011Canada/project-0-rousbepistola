package com.worldbank.launcher;

import java.util.Scanner;

import com.worldbank.menu.MainMenuLauncher;

import java.io.Console;

public class EmployeeLogin {
	
	String username;
	String pass;
	String[] login = new String[2];
	
	Scanner loginScan = new Scanner(System.in);
	Console console = System.console();
	MainMenuLauncher mainMenu = new MainMenuLauncher();
	
	public String[] employeeLogin() {
		
		System.out.println("");
		System.out.println("          Login with username and password          ");
		System.out.println("");
		System.out.print("USERNAME: ");
		username = loginScan.nextLine();
		System.out.print("PASSWORD: ");
		pass = loginScan.nextLine();
		mainMenu.clearConsole(10);

		
//		System.out.println("Your username: " + username + " and password: " + pass);
		login[0] = username;
		login[1] = pass;
//		System.out.println(login[0]);

		return login;
		
	}

	

}


//WORKING ON SOME CODE TO HIDE PASSWORD
//if(console != null) {
//pass = console.readLine();
//} else {
//System.out.println("Console is not available");
//}
//
//
//pass = console.readPassword();