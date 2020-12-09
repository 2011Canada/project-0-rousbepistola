package com.worldbank.models;

public class Customer {

	String fname;
	String lname;
	int userId;
	String username;
	String pass;
	String userType; //defaults to user
	
	
	
	//CONSTRUCTORS
	
	public Customer(String fname, String lname, int userId, String username, String pass, String userType) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userType = userType;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "Customer [fname=" + fname + ", lname=" + lname + ", userId=" + userId + ", username=" + username
				+ ", pass=" + pass + ", userType=" + userType + "]";
	}

	
	
	//METHODS
	
	public void createNewAccount() {
		
	};
	
	public void withdraw() {
		
	};
	
	public void deposit() {
		
	};
	

	
	
	
	
	
	
	
	
	
	
}
