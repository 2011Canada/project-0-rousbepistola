package com.worldbank.models;

public class Employee{
	

	String fname;
	String lname;
	int userId;
	String username;
	String pass;
	String userType; //defaults to employee

	
//	CONSTRUCTORS
	
	public Employee(String fname, String lname, int userId, String username, String pass, String userType) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userType = userType;
	}

	public Employee() {
		super();
	}
	
	
//	METHODS
	public void approveOrRejectAccount() {
		
	};
	
	public void viewCustomerAccount() {
		
	};

	public void viewCustomerTransactions() {
		
	};
	
	
	
	

}
