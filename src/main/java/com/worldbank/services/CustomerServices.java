package com.worldbank.services;


public class CustomerServices {
	
	String fname;
	String lname;
	String user_id;
	
	

	public void CustomerMain(String[] credentials) {
		fname = credentials[0];
		lname = credentials[1];
		user_id = credentials[4];
		
		System.out.print(credentials[0] + " " + credentials[1]);
		System.out.println("");
		
		
		
		
	}

	


	
	
	
	
	
	

}
